package com.portales.proyecto_apps.login.loginfragment

data class LoginModel(var email: String = "", var password: String = "") {
    fun isnotEmpty():Boolean{
        return (email.isNotEmpty() && password.isNotEmpty()) &&
                (email.isNotBlank() && password.isNotBlank())
    }
}