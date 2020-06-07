package com.portales.proyecto_apps.principal.ajustes.updateinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UpdateViewModel : ViewModel() {

    private val model = MutableLiveData<UpdateInfoModel>()
    private val UpdateUseCase = UpdateUseCase()

    fun getModel() : MutableLiveData<UpdateInfoModel>{
        UpdateUseCase.getData().observeForever{
            model.value = it
        }
        return model
    }



}