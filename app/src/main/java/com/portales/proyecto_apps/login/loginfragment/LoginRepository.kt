package com.portales.proyecto_apps.login.loginfragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.principal.MainActivity

class LoginRepository{

    private val db = FirebaseFirestore.getInstance()

    fun Login(model:LoginModel, context: Context){
        db.collection("users").document(model.email).get().addOnCompleteListener {
            if (it.isSuccessful){
                val result = it.result?.get("password").toString()
                if (result.equals(model.password)){
                    var intent = Intent(context as Activity, MainActivity::class.java)
                    intent.putExtra("user", model.email)
                    (context as Activity).startActivity(intent)
                    (context as Activity).finish()
                }else{
                    Toast.makeText(context, "Usuario incorrecto", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(context, "No se obtuvo respuesta del servidor", Toast.LENGTH_LONG).show()
            }
        }
    }


}