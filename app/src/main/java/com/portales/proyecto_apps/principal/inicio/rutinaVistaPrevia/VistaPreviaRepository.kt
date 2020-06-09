package com.portales.proyecto_apps.principal.inicio.rutinaVistaPrevia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class VistaPreviaRepository {

    private val db = FirebaseFirestore.getInstance()

    fun setFav(){
        db.collection("rutinas")
    }

    fun unsetFav(){

    }

    fun getData(id: String): LiveData<Boolean> {
       val MutableData = MutableLiveData<Boolean>()
        db.collection("users")
        return MutableData
    }

}