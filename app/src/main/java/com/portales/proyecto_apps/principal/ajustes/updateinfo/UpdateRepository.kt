package com.portales.proyecto_apps.principal.ajustes.updateinfo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class UpdateRepository {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun getData():LiveData<UpdateInfoModel>{
        var model = MutableLiveData<UpdateInfoModel>()
        db.collection("users").document(auth.currentUser?.email!!).get().addOnCompleteListener {
            if (it.isSuccessful){
                val result = it.result
                val model1 = UpdateInfoModel(result?.get("name").toString(),
                                        result?.get("birth").toString(),
                                        result?.get("height").toString(),
                                        result?.get("weight").toString())
               model.value = model1
            }
        }
        return model
    }
}