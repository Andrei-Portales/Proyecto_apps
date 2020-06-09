package com.portales.proyecto_apps.principal.preview

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class PreviewRoutineRepository {

    private val db = FirebaseFirestore.getInstance()

    fun obtenerRutina(idDocumento: String): RutinaModel {
        var rutinaResultado = RutinaModel()
        db.collection("rutinas")
            .get().addOnCompleteListener {
                val list = ArrayList<RutinaModel>()
                if (it.isSuccessful){
                    for (d in it.result!!){
                        val rutina = RutinaModel()
                        rutina.createFromQueryDocumentSnapshot(d)
                        if (rutina.id ==idDocumento){
                        rutinaResultado = rutina}
                    }

                }
            }
        return rutinaResultado
    }


    fun getData(parametro: String): LiveData<RutinaModel> {
        val MutableData = MutableLiveData<RutinaModel>()
        db.collection("rutinas").whereEqualTo("id",parametro)
            .get().addOnCompleteListener {
                var list = RutinaModel()
                if (it.isSuccessful){
                    for (d in it.result!!){
                        val rutina = RutinaModel()
                        rutina.createFromQueryDocumentSnapshot(d)
                        list =rutina
                    }
                    MutableData.value = list
                }
            }
        return MutableData
    }

}