package com.portales.proyecto_apps.principal.publicar.addroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class AddRoutineRepository {
    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val user = auth.currentUser


    fun getUserEmail():String{

        return user?.email!!

    }


    fun putRoutine(model: RutinaModel, context: Context){
        db.collection("rutinas").add(model.getMap()).addOnCompleteListener{
            if (it.isSuccessful) {
                Toast.makeText(context, "Se logro agregar a la rutina a FitMe", Toast.LENGTH_LONG)
                    .show()
            }

        }.addOnFailureListener {
            Toast.makeText(context,"Ha sucedido un error, Intentalo mas tarde",Toast.LENGTH_LONG).show()
        }

    }
}
