package com.mysamples.mvc.model

import com.mysamples.mvc.model.validator.LoginValidator


object ModelModule {

    val dataAccessLayer : DataAccessLayer by lazy { dataAccessLayer() }

    private fun dataAccessLayer() = DataAccessLayer(LoginValidator(), AccountRepository())
}