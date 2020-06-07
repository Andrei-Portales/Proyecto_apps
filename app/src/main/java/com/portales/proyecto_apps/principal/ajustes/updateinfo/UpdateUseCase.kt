package com.portales.proyecto_apps.principal.ajustes.updateinfo

import androidx.lifecycle.LiveData


class UpdateUseCase {

    private val UpdateRepository = UpdateRepository()

    fun getData(): LiveData<UpdateInfoModel> {
        return UpdateRepository.getData()
    }
}