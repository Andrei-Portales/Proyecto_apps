package com.portales.proyecto_apps.principal.ajustes.updateinfo

import java.lang.Exception

data class UpdateInfoModel (var name:String = "", var birth:String ="", var height:String = "", var weight:String = "") {

    fun isEmpty():Boolean{
        return name.equals("") && birth.equals("") && height.equals("") && weight.equals("")
    }

    fun areEmpty(): Boolean{
        val isnotEmpty =  (name?.isNotBlank()!! || name?.isNotEmpty()!!) &&
                (birth.isNotBlank() || birth.isNotEmpty()) &&
                (weight.isNotBlank() || weight.isNotEmpty()) &&
                (height.isNotBlank() || height.isNotEmpty())
        return isnotEmpty
    }

    fun areNumbers(): Boolean{
        try {
            weight.toFloat()
        }catch (e: Exception){
            return false
        }

        try {
            height.toFloat()
        }catch (e: Exception){
            return false
        }
        return true
    }
}