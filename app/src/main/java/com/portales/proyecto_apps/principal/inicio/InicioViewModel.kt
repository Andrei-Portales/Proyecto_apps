package com.portales.proyecto_apps.principal.inicio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class InicioViewModel : ViewModel() {

    private val InicioRepository = InicioRepository()
    private val model = MutableLiveData<List<RutinaModel>>()


    fun getData() : MutableLiveData<List<RutinaModel>> {
        InicioRepository.getData().observeForever{
            model.value = it
        }
        return model
    }



}