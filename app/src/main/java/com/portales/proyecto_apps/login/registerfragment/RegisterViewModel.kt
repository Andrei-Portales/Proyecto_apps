package com.portales.proyecto_apps.login.registerfragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class RegisterViewModel : ViewModel() {

    val RegisterUseCase = RegisterUseCase()

    fun register(
        model: RegisterModel,
        context: Context,
        NavController: NavController
    ){
        RegisterUseCase.register(model, context, NavController)
    }

}