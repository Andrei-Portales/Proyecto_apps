package com.portales.proyecto_apps.principal.inicio

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.principal.publicacionmodel.EjercicioModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class InicioRepository  {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun getData(): LiveData<List<RutinaModel>> {
        val MutableData = MutableLiveData<List<RutinaModel>>()
        db.collection("rutinas").whereEqualTo("user",auth.currentUser?.email)
            .get().addOnCompleteListener {
            val list = ArrayList<RutinaModel>()
            if (it.isSuccessful){
                for (d in it.result!!){
                        val rutina = RutinaModel(d.get("title").toString(),
                        d.get("description").toString(),d.get("time").toString().toFloat()
                        , d.get("user").toString(), d.get("video").toString())

                        val listMaps:List<HashMap<String, Any?>> = d.get("exercises") as List<HashMap<String, Any?>>
                        for(map in listMaps){
                            rutina.exercises.add(EjercicioModel(map.get("title").toString(),
                            map.get("description").toString(), map.get("video").toString()))
                        }

                        list.add(rutina)
                }
                MutableData.value = list
            }
        }
        return MutableData
    }
}