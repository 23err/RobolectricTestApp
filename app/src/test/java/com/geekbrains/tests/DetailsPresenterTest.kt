package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class DetailsPresenterTest {
    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        presenter = DetailsPresenter(viewContract = viewContract)
    }

    @Test
    fun onIncrementSetCountInvoke_Test(){
        var count = 0
        presenter.onIncrement()
        Mockito.verify(viewContract, times(1)).setCount(++count)
    }

    @Test
    fun onDecrementSetCountInvoke_Test(){
        var count = 0
        presenter.onDecrement()
        Mockito.verify(viewContract, times(1)).setCount(--count)
    }

    @Test
    fun onAttachViewContract_Test(){
        presenter.onAttach(viewContract)
        Assert.assertNotNull(presenter.getViewContract())
    }

    @Test
    fun onDetachViewContract_Test(){
        presenter.onDetach()
        Assert.assertNull(presenter.getViewContract())
    }

}