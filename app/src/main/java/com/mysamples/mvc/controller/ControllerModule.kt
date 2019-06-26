package com.mysamples.mvc.controller

import com.mysamples.mvc.model.ModelModule


object ControllerModule {

    fun loginController() = LoginController(ModelModule.dataAccessLayer)
}