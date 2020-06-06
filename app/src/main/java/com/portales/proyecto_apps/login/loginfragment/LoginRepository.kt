package com.portales.proyecto_apps.login.loginfragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.portales.proyecto_apps.principal.MainActivity

class LoginRepository{

    private val auth = FirebaseAuth.getInstance()

    fun Login(
        model: LoginModel,
        context: Context,
        progressLogin: ProgressBar,
        btnIniciarSesion: Button
    ){
       auth.signInWithEmailAndPassword(model.email, model.password)
           .addOnCompleteListener {
            if (it.isSuccessful){
                    var intent = Intent(context as Activity, MainActivity::class.java)
                    (context as Activity).startActivity(intent)
                    (context as Activity).finish()
                progressLogin.visibility = View.GONE
                btnIniciarSesion.visibility = View.VISIBLE
                }else {
                Toast.makeText(context, "Usuario incorrecto", Toast.LENGTH_LONG).show()
                progressLogin.visibility = View.GONE
                btnIniciarSesion.visibility = View.VISIBLE
            }
        }.addOnFailureListener {
           Toast.makeText(context, "No se pudo contectar al servidor", Toast.LENGTH_LONG).show()
               progressLogin.visibility = View.GONE
               btnIniciarSesion.visibility = View.VISIBLE
       }
    }


}