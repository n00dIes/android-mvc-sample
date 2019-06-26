package com.mysamples.mvc.controller

import com.mysamples.mvc.model.DataAccessLayer
import com.mysamples.mvc.view.LoginView


class LoginController(private val model: DataAccessLayer) {

    private lateinit var view: LoginView

    fun bind(loginView: LoginView) {
        view = loginView
    }

    fun onLoginButtonClicked() {
        model.performLogin(view.getUsername(), view.getPassword())
    }

}