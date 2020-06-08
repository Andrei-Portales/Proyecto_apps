package com.portales.proyecto_apps.principal.ajustes.changepass

import android.content.Context
import android.widget.Button
import android.widget.ProgressBar
import androidx.navigation.NavController

class ChangePassUseCase {

    private val ChangePassRepository = ChangePassRepository()

    fun changePass(
        context: Context?,
        changeModel: ChangePassModel,
        btnConfirmChange: Button,
        progressChangepass: ProgressBar,
        findNavController: NavController
    ) {
       ChangePassRepository.changePass(context, changeModel, btnConfirmChange, progressChangepass, findNavController)
    }
}