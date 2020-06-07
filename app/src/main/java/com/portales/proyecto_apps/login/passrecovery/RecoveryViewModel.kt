package com.portales.proyecto_apps.login.passrecovery

import android.content.Context
import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class RecoveryViewModel: ViewModel() {

    private val RecoveryUseCase = RecoveryUseCase()

    fun recovery(
        recoveryModel: RecoveryModel,
        progressRecovery: ProgressBar,
        btnRecovery: Button,
        context: Context?,
        findNavController: NavController
    ) {
        RecoveryUseCase.recovery(recoveryModel, progressRecovery, btnRecovery, context,findNavController)
    }
}