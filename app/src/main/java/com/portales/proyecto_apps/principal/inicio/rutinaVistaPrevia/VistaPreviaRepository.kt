package com.portales.proyecto_apps.principal.inicio.rutinaVistaPrevia

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class VistaPreviaRepository {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance().currentUser

    fun setFav(id:String, context: Context){
        db.collection("users").document(auth?.email!!).get().addOnCompleteListener {
            if(it.isSuccessful){
                val result = it.result?.get("favorites") as ArrayList<String>
                if (id in result){
                    result.remove(id)
                    val hashMap = HashMap<String, Any?>()
                    hashMap.put("favorites",result)
                    db.collection("users").document(auth?.email!!).update(hashMap).addOnSuccessListener {
                        Toast.makeText(context, "Se elimino rutina de favoritas", Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {
                        Toast.makeText(context, "No se pudo conectar con la base de datos", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    result.add(id)
                    val hashMap = HashMap<String, Any?>()
                    hashMap.put("favorites",result)
                    db.collection("users").document(auth?.email!!).update(hashMap).addOnSuccessListener {
                        Toast.makeText(context, "Se agrego rutina a favoritas", Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {
                        Toast.makeText(context, "No se pudo conectar con la base de datos", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(context, "No se pudo conectar con la base de datos", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(context, "No se pudo conectar con la base de datos", Toast.LENGTH_SHORT).show()
        }
    }



}