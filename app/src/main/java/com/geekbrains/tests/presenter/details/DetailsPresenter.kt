package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.view.details.ViewDetailsContract

internal class DetailsPresenter internal constructor(
    private var count: Int = 0,
    private var viewContract: ViewDetailsContract? = null
) : PresenterDetailsContract {

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count++
        viewContract?.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract?.setCount(count)
    }

    override fun onAttach(viewContract: ViewDetailsContract) {
        this.viewContract = viewContract
    }

    override fun onDetach() {
        viewContract = null
    }

    fun getViewContract() = viewContract
}
