package com.portales.proyecto_apps.login.registerfragment

import android.app.Activity
import android.app.Application
import android.util.Log
import android.widget.Toast

import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.principal.MainActivity
import kotlinx.coroutines.yield

class RegisterRepository {



    fun Register(model: RegisterModel){
        Log.d("MODEL", model.email.toString())
        val db = FirebaseFirestore.getInstance()
        val user = HashMap<String, Any?>()
        user.put("name", model.name)
        user.put("email", model.email)
        user.put("password", model.password)
        user.put("birth", model.birth)
        user.put("weight", model.weight)
        user.put("height", model.height)
        Log.d("DBCONECTION", db.toString())
        db.collection("users").document(model.email.toString()).set(user).addOnCompleteListener {
            Log.d("FIREBASEEXITO", it.result.toString())
        }.addOnFailureListener {
            Log.d("FIREBASEFAILURE", it.message.toString())
        }
    }


}