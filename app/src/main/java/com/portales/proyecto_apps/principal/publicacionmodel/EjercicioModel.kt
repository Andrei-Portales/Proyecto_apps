package com.portales.proyecto_apps.principal.publicacionmodel

data class EjercicioModel (var title:String = "", var description:String = "", var video:String = "")
    :IElemento{

    fun isOk():Boolean{
        return title.isNotEmpty() && title.isNotBlank() && description.isNotEmpty()
                && description.isNotBlank() && video.isNotEmpty() && video.isNotBlank()
    }
}