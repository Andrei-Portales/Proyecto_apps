package com.portales.proyecto_apps.principal.rutinasfavoritas

import androidx.lifecycle.MutableLiveData
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class RutinasFavoritasViewModel {

    private val model = MutableLiveData<List<RutinaModel>>()
    private val RutinasFavoritasRepository = com.portales.proyecto_apps.principal.rutinasfavoritas.RutinasFavoritasRepository()



    fun getModel() : MutableLiveData<List<RutinaModel>> {
        RutinasFavoritasRepository.getData().observeForever{
            model.value = it
        }
        return model
    }

}