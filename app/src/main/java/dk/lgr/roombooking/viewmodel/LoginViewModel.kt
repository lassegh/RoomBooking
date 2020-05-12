package dk.lgr.roombooking.viewmodel

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import dk.lgr.roombooking.helpers.LoginHelper

class LoginViewModel(context:Context) {

    val context = context
    val loginHelper = LoginHelper()

    var email:String = ""
    var password:String = ""

    fun onLogin(){
        if (email.isEmpty() || password.isEmpty()) loginFailed() else {
            loginHelper.login(email, password, context as Activity)
        }
    }

    fun loginFailed(){
        Toast.makeText(context, "Login failed. Try again.", Toast.LENGTH_LONG).show()
    }
}