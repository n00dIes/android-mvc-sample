package com.mysamples.mvc.model

import com.mysamples.mvc.model.domain.Account

class AccountRepository {

    internal var account: Account = Account(firstName = "James", lastName = "Smith", email = "james.smith@foo.com")
}
