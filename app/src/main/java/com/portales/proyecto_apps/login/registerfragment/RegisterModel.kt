package com.portales.proyecto_apps.login.registerfragment

import java.lang.Exception

data class RegisterModel(var name: String? = "", var email: String? = "",
                         var password : String? = "", var cpassword:String? = "",
                         var birth: String = "", var weight: String = "",
                         var height: String = "") {

    fun isOk(): Boolean{
        try {
            weight.toFloat()
        }catch (e:Exception){
            return false
        }

        try {
            height.toFloat()
        }catch (e:Exception){
            return false
        }

        val isnotEmpty =  (name?.isNotBlank()!! || name?.isNotEmpty()!!) &&
                (email?.isNotBlank()!! || email?.isNotEmpty()!!) &&
                (password?.isNotBlank()!! || password?.isNotEmpty()!!) &&
                (cpassword?.isNotBlank()!! || cpassword?.isNotEmpty()!!) &&
                (birth.isNotBlank() || birth.isNotEmpty()) &&
                (weight.isNotBlank() || weight.isNotEmpty()) &&
                (height.isNotBlank() || height.isNotEmpty()) &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()

        return isnotEmpty
    }

}