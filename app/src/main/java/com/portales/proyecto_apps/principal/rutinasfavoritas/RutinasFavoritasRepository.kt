package com.portales.proyecto_apps.principal.rutinasfavoritas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.principal.publicacionmodel.EjercicioModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class RutinasFavoritasRepository {

    private val db = FirebaseFirestore.getInstance()

    fun getData(): LiveData<List<RutinaModel>> {
        val MutableData = MutableLiveData<List<RutinaModel>>()
        db.collection("rutinas").get().addOnCompleteListener {
            val list = ArrayList<RutinaModel>()
            if (it.isSuccessful){
                for (d in it.result!!){
                    list.add(
                        RutinaModel(d.get("title").toString(),
                            d.get("description").toString(),d.get("time").toString().toFloat()
                            , d.get("user").toString(), d.get("video").toString())
                    )

                }
                MutableData.value = list
            }
        }
        return MutableData
    }
}