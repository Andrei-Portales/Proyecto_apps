package com.portales.proyecto_apps.login.passrecovery

import android.content.Context
import android.widget.Button
import android.widget.ProgressBar
import androidx.navigation.NavController

class RecoveryUseCase{

    private val RecoveryRepository = RecoveryRepository()

    fun recovery(
        recoveryModel: RecoveryModel,
        progressRecovery: ProgressBar,
        btnRecovery: Button,
        context: Context?,
        findNavController: NavController
    ) {
        RecoveryRepository.recovery(recoveryModel,progressRecovery,btnRecovery,context,findNavController)
    }

}