package com.mysamples.mvc.model.observer


interface AccountObserver : DomainObserver {

    fun accountLoggedIn()

    fun accountUnknown()
}