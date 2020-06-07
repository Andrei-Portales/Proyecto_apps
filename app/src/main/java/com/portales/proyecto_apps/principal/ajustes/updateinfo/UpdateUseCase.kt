package com.portales.proyecto_apps.principal.ajustes.updateinfo

import android.content.Context
import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.navigation.NavController


class UpdateUseCase {

    private val UpdateRepository = UpdateRepository()

    fun getData(): LiveData<UpdateInfoModel> {
        return UpdateRepository.getData()
    }

    fun change(
        context: Context?,
        findNavController: NavController,
        updateInfoModel: UpdateInfoModel,
        progressInfoChange: ProgressBar,
        btnRegistrarseChange: Button
    ) {
        UpdateRepository.change(context,findNavController,updateInfoModel
            ,progressInfoChange,btnRegistrarseChange)
    }
}