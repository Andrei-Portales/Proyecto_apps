package com.portales.proyecto_apps.principal.ajustes.changepass

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class ChangePassRepository {

    val auth = FirebaseAuth.getInstance()

    fun changePass(
        context: Context?,
        changeModel: ChangePassModel,
        btnConfirmChange: Button,
        progressChangepass: ProgressBar,
        findNavController: NavController
    ) {
        progressChangepass.visibility = View.VISIBLE
        btnConfirmChange.visibility = View.GONE
        auth.currentUser?.updatePassword(changeModel.password)?.addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context, "La contraseña se cambio con exito", Toast.LENGTH_SHORT).show()
                findNavController.navigate(R.id.action_changePassFragment_to_ajustesFragment)
            }else{
                Toast.makeText(context, "No se pudo cambiar la contraseña", Toast.LENGTH_SHORT).show()
                btnConfirmChange.visibility = View.VISIBLE
                progressChangepass.visibility = View.GONE
            }
        }?.addOnFailureListener {
            Toast.makeText(context, "No se pudo cambiar la contraseña", Toast.LENGTH_SHORT).show()
            btnConfirmChange.visibility = View.VISIBLE
            progressChangepass.visibility = View.GONE
        }
    }

}