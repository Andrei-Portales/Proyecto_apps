package com.portales.proyecto_apps.principal.ajustes.changepass

data class ChangePassModel (var password:String = "", var cPassword:String = "") {

    fun isOk():Boolean{
        return password.equals(cPassword) && password.isNotEmpty() && password.isNotBlank() && password.length>=8
    }
}