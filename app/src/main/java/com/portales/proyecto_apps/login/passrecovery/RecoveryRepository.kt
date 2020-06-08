package com.portales.proyecto_apps.login.passrecovery

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.portales.proyecto_apps.R

class RecoveryRepository {

    private val auth = FirebaseAuth.getInstance()

    fun recovery(
        recoveryModel: RecoveryModel,
        progressRecovery: ProgressBar,
        btnRecovery: Button,
        context: Context?,
        findNavController: NavController
    ) {
        progressRecovery.visibility = View.VISIBLE
        btnRecovery.visibility = View.GONE
        auth.sendPasswordResetEmail(recoveryModel.email).addOnCompleteListener {
            if (it.isSuccessful){
                progressRecovery.visibility = View.GONE
                btnRecovery.visibility = View.VISIBLE
                Toast.makeText(context, "Se envio el correo con exito", Toast.LENGTH_LONG).show()
                findNavController.navigate(R.id.action_passwordRecoveryFragment_to_loginFragment)
            }else{
                progressRecovery.visibility = View.GONE
                btnRecovery.visibility = View.VISIBLE
                Toast.makeText(context, "No se envio el correo", Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener {
            progressRecovery.visibility = View.GONE
            btnRecovery.visibility = View.VISIBLE
            Toast.makeText(context, "No se envio el correo", Toast.LENGTH_LONG).show()
        }
    }
}