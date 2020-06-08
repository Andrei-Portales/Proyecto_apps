package com.portales.proyecto_apps.principal.rutinadiaria.Start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class StartRutinaViewModel : ViewModel() {

    private val model = MutableLiveData<List<RutinaModel>>()
    private val StartRutinaRepository = StartRutinaRepository()



    fun getModel() : MutableLiveData<List<RutinaModel>> {
        StartRutinaRepository.getData().observeForever{
            model.value = it
        }
        return model
    }


}