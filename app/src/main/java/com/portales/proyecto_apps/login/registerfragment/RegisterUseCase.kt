package com.portales.proyecto_apps.login.registerfragment

class RegisterUseCase {

    private val RegisterRepository = RegisterRepository()

    fun register(model: RegisterModel){
        RegisterRepository.Register(model)
    }

}