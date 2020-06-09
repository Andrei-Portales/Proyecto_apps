package com.portales.proyecto_apps.principal.preview

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class PreviewRoutineRepository {

    private val db = FirebaseFirestore.getInstance()

    fun obtenerRutina(idDocumento: String): RutinaModel {
        val rutina = RutinaModel()
       val request =db.collection("rutinas").document(idDocumento).get()
        request.addOnCompleteListener {
            val list = ArrayList<RutinaModel>()
            if (it.isSuccessful){
                rutina.createFromQueryDocumentSnapshot(it.result as QueryDocumentSnapshot)
            }
        }

        return rutina

    }

}