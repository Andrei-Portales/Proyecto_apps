package com.portales.proyecto_apps.principal.ajustes.changepass

import android.content.Context
import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class ChangePassViewModel : ViewModel() {

    private val ChangePassUseCase = ChangePassUseCase()

    fun changePass(
        context: Context?,
        changeModel: ChangePassModel,
        btnConfirmChange: Button,
        progressChangepass: ProgressBar,
        findNavController: NavController
    ) {
        ChangePassUseCase.changePass(context, changeModel, btnConfirmChange, progressChangepass,findNavController)
    }

}