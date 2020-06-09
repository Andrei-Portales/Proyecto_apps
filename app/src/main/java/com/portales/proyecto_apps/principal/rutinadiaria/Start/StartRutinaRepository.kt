package com.portales.proyecto_apps.principal.rutinadiaria.Start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class StartRutinaRepository {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun getData(): LiveData<List<RutinaModel>> {
        val MutableData = MutableLiveData<List<RutinaModel>>()
        db.collection("rutinas").whereEqualTo("user",auth.currentUser?.email)
            .get().addOnCompleteListener {
                val list = ArrayList<RutinaModel>()
                if (it.isSuccessful){
                    for (d in it.result!!){
                        val rutina = RutinaModel()
                        rutina.createFromQueryDocumentSnapshot(d)
                        list.add(rutina)
                    }
                    MutableData.value = list
                }
            }
        return MutableData
    }

}