package com.portales.proyecto_apps.login.registerfragment

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController

import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.R


class RegisterRepository {

    private val db = FirebaseFirestore.getInstance()

    fun Register(
        model: RegisterModel,
        context: Context,
        navController: NavController
    ){
        db.collection("users").document(model.email.toString()).get()
            .addOnCompleteListener {
            if (it.isSuccessful){
                val result = it.result?.get("email").toString()
                if (result.equals(model.email)){
                    Toast.makeText(context, "Ya exite un usuario con ese correo", Toast.LENGTH_LONG).show()
                }else{
                    registro(model, context, navController)
                }
            }else{
                Toast.makeText(context,"Fallo consulta a servidor", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun registro(
        model: RegisterModel,
        context: Context,
        navController: NavController
    ){
        val user = HashMap<String, Any?>()
        user.put("name", model.name)
        user.put("email", model.email)
        user.put("password", model.password)
        user.put("birth", model.birth)
        user.put("weight", model.weight.toFloat())
        user.put("height", model.height.toFloat())
        user.put("image", null)
        db.collection("users").document(model.email.toString()).set(user).addOnCompleteListener {
            navController.navigate(R.id.action_registerFragment_to_loginFragment)
            Toast.makeText(context, "Se registro con exito", Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            Toast.makeText(context, "No se logro registrar el usuario", Toast.LENGTH_LONG).show()
        }
    }



}