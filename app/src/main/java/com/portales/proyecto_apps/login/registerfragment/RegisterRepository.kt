package com.portales.proyecto_apps.login.registerfragment

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.portales.proyecto_apps.R


class RegisterRepository {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val storage = FirebaseStorage.getInstance().getReference().child("users")

    fun Register(
        model: RegisterModel,
        context: Context,
        navController: NavController
    ){
        auth.createUserWithEmailAndPassword(model.email.toString(), model.password.toString())
            .addOnCompleteListener {
            if (it.isSuccessful){
                val profileUpdates = UserProfileChangeRequest.Builder()
                    .setDisplayName(model.name.toString())
                    .build()
                val user = auth.currentUser
                user?.updateProfile(profileUpdates)
                registro(model, context, navController)
            }else{
                Toast.makeText(context,"Usuario ya existe", Toast.LENGTH_LONG).show()
            }
            }.addOnFailureListener {
                Toast.makeText(context,"No se pudo crear Usuario1", Toast.LENGTH_LONG).show()
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
        user.put("birth", model.birth)
        user.put("weight", model.weight.toFloat())
        user.put("height", model.height.toFloat())
        user.put("favorites", ArrayList<String>() as List<String>)
        user.put("image", null)
        db.collection("users").document(model.email.toString()).set(user).addOnCompleteListener {
            navController.navigate(R.id.action_registerFragment_to_loginFragment)
            Toast.makeText(context, "Se registro con exito", Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            Toast.makeText(context, "No se logro registrar el usuario", Toast.LENGTH_LONG).show()
        }
    }



}