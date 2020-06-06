package com.portales.proyecto_apps.login.loginfragment

import android.content.Context

class LoginUseCase {

    private val repository = LoginRepository()

    fun Login(model: LoginModel, context: Context){
        repository.Login(model, context)
    }
}