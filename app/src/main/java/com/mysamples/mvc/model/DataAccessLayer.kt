package com.mysamples.mvc.model

import com.mysamples.mvc.model.domain.Credential
import com.mysamples.mvc.model.observer.AccountObserver
import com.mysamples.mvc.model.observer.DomainObserver
import com.mysamples.mvc.model.validator.Validator


class DataAccessLayer(
    private val userValidator: Validator,
    private val accountRepository: AccountRepository
) {

    private val observers = mutableListOf<DomainObserver>()

    fun register(observer: DomainObserver) = observers.add(observer)

    fun unregister(observer: DomainObserver) = observers.remove(observer)

    fun performLogin(username: String, password: String) {
        val credentials = Credential(username, password)

        if (userValidator.validate(credentials)) {
            notify(AccountObserver::accountLoggedIn)
        } else {
            notify(AccountObserver::accountUnknown)
        }
    }

    private fun notify(action: (AccountObserver) -> Unit) {
        observers.filterIsInstance<AccountObserver>().onEach { action(it) }
    }

    fun getCurrentAccount() = accountRepository.account
}