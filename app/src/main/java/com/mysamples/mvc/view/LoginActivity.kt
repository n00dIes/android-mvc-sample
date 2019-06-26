package com.mysamples.mvc.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mysamples.mvc.R
import com.mysamples.mvc.controller.ControllerModule.loginController
import com.mysamples.mvc.model.ModelModule
import com.mysamples.mvc.model.observer.AccountObserver
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity(), LoginView, AccountObserver {

    private val model = ModelModule.dataAccessLayer
    private val controller = loginController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller.bind(this)

        login_btn.setOnClickListener {
            controller.onLoginButtonClicked()
        }
    }

    override fun onStart() {
        super.onStart()
        model.register(this)
    }

    override fun onStop() {
        super.onStop()
        model.unregister(this)
    }

    override fun getUsername() = username.text.toString()

    override fun getPassword() = password.text.toString()

    override fun accountLoggedIn() {
        val account = queryAccount()
        showMessage("Hello ${account.firstName} ${account.lastName}!")
    }

    override fun accountUnknown() {
        showMessage("Incorrect username or password")
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun queryAccount() = model.getCurrentAccount()
}
