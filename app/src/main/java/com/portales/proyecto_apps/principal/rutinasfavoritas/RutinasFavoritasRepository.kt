package com.portales.proyecto_apps.principal.rutinasfavoritas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class RutinasFavoritasRepository {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun getData(): LiveData<List<RutinaModel>> {
        val MutableData = MutableLiveData<List<RutinaModel>>()
        db.collection("users").document(auth.currentUser?.email!!).get()
            .addOnCompleteListener {
                if (it.isSuccessful){
                    val result = it.result?.get("favorites") as List<String>
                    db.collection("rutinas")
                        .get().addOnCompleteListener {
                            val list = ArrayList<RutinaModel>()
                            if (it.isSuccessful){
                                for (d in it.result!!){
                                    val rutina = RutinaModel()
                                    rutina.createFromQueryDocumentSnapshot(d)
                                    if (rutina.id in result){
                                        list.add(rutina)
                                    }
                                }
                                MutableData.value = list
                            }
                        }


                }
            }
        return MutableData
    }
}