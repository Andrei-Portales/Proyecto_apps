package com.portales.proyecto_apps.principal.ajustes.updateinfo

import android.content.Context
import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class UpdateViewModel : ViewModel() {

    private val model = MutableLiveData<UpdateInfoModel>()
    private val UpdateUseCase = UpdateUseCase()

    fun getModel() : MutableLiveData<UpdateInfoModel>{
        UpdateUseCase.getData().observeForever{
            model.value = it
        }
        return model
    }

    fun change(
        context: Context?,
        findNavController: NavController,
        updateInfoModel: UpdateInfoModel,
        progressInfoChange: ProgressBar,
        btnRegistrarseChange: Button
    ) {
        UpdateUseCase.change(context,findNavController,updateInfoModel,
            progressInfoChange,btnRegistrarseChange)
    }



}