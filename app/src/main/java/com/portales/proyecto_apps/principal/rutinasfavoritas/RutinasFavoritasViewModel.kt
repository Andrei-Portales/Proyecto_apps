package com.portales.proyecto_apps.principal.rutinasfavoritas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class RutinasFavoritasViewModel : ViewModel() {

    private val RutinasFavoritasRepository = RutinasFavoritasRepository()
    private val model = MutableLiveData<List<RutinaModel>>()


    fun getData() : MutableLiveData<List<RutinaModel>> {
        RutinasFavoritasRepository.getData().observeForever{
            model.value = it
        }
        return model
    }

}