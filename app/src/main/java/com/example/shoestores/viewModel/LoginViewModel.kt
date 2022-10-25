package com.example.shoestores.viewModel

import android.util.Patterns
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){


    fun checkValidationUserName(userName :String):Boolean{
        return !userName.isNullOrEmpty()
    }


    fun checkValidationEmail(email: String): Boolean {

        return (!email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())


    }

    fun checkValidationPassword(password: String):Boolean{
        return !password.isNullOrEmpty() && password.length > 6
    }

}



