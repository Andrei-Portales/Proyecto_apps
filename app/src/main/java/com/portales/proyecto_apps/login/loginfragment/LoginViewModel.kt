package com.portales.proyecto_apps.login.loginfragment

import android.content.Context
import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    private val useCase = LoginUseCase()

    fun Login(
        model: LoginModel,
        context: Context,
        progressLogin: ProgressBar,
        btnIniciarSesion: Button
    ){
        useCase.Login(model, context, progressLogin, btnIniciarSesion)
    }
}