package com.portales.proyecto_apps.principal.rutinadiaria

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.portales.proyecto_apps.principal.ajustes.updateinfo.UpdateInfoModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class RutinaDiariaViewModel : ViewModel() {

    private val model = MutableLiveData<List<RutinaModel>>()
    private val RutinaDiariaRepository = RutinaDiariaRepository()


    fun getModel() : MutableLiveData<List<RutinaModel>> {
        RutinaDiariaRepository.getData().observeForever{
            model.value = it
        }
        return model
    }

}