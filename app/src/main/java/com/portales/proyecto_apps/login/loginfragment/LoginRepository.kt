package com.portales.proyecto_apps.login.loginfragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.portales.proyecto_apps.principal.MainActivity

class LoginRepository{

    private val auth = FirebaseAuth.getInstance()

    fun Login(model:LoginModel, context: Context){
       auth.signInWithEmailAndPassword(model.email, model.password)
           .addOnCompleteListener {
            if (it.isSuccessful){
                    var intent = Intent(context as Activity, MainActivity::class.java)
                    (context as Activity).startActivity(intent)
                    (context as Activity).finish()
                }else {
                Toast.makeText(context, "Usuario incorrecto", Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener {
           Toast.makeText(context, "No se pudo contectar al servidor", Toast.LENGTH_LONG).show()
       }
    }


}