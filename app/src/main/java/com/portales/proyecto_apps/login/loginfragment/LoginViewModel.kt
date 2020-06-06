package com.portales.proyecto_apps.login.loginfragment

import android.content.Context
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    private val useCase = LoginUseCase()

    fun Login(model: LoginModel, context: Context){
        useCase.Login(model, context)
    }
}