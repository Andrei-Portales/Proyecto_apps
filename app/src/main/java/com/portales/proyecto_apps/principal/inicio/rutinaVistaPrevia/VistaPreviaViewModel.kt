package com.portales.proyecto_apps.principal.inicio.rutinaVistaPrevia

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VistaPreviaViewModel : ViewModel() {

    private val VistaPreviaRepository = VistaPreviaRepository()
    private val fav = MutableLiveData<Boolean>()


    fun setFav(id:String, context: Context){
        VistaPreviaRepository.setFav(id,context)
    }

}