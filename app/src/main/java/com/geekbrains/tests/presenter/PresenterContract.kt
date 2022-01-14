package com.geekbrains.tests.presenter

import com.geekbrains.tests.view.ViewContract

internal interface PresenterContract<in T: ViewContract> {
    fun onAttach(viewContract: T)
    fun onDetach()
}
