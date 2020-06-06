package com.portales.proyecto_apps.login.registerfragment

import android.content.Context
import androidx.navigation.NavController

class RegisterUseCase {

    private val RegisterRepository = RegisterRepository()

    fun register(
        model: RegisterModel,
        context: Context,
        navController: NavController
    ){
        RegisterRepository.Register(model, context, navController)
    }

}