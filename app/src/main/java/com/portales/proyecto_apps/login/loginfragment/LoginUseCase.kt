package com.portales.proyecto_apps.login.loginfragment

import android.content.Context
import android.widget.Button
import android.widget.ProgressBar

class LoginUseCase {

    private val repository = LoginRepository()

    fun Login(
        model: LoginModel,
        context: Context,
        progressLogin: ProgressBar,
        btnIniciarSesion: Button
    ){
        repository.Login(model, context, progressLogin, btnIniciarSesion)
    }
}