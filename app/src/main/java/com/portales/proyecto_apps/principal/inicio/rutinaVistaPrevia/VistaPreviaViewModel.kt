package com.portales.proyecto_apps.principal.inicio.rutinaVistaPrevia

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VistaPreviaViewModel : ViewModel() {

    private val VistaPreviaRepository = VistaPreviaRepository()
    private val fav = MutableLiveData<Boolean>()


    fun getData(id:String) : MutableLiveData<Boolean> {
        VistaPreviaRepository.getData(id).observeForever{
            fav.value = it
        }
        return fav
    }

    fun setFav(id:String){

    }

}