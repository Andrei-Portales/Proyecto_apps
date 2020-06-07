package com.portales.proyecto_apps.principal.ajustes.updateinfo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
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
            }else{
                model.value = UpdateInfoModel()
            }
        }.addOnFailureListener {
            model.value = UpdateInfoModel()
        }
        return model
    }

    fun change(
        context: Context?,
        findNavController: NavController,
        model: UpdateInfoModel
    ) {
        val user = HashMap<String, Any?>()
        user.put("name", model.name)
        user.put("birth", model.birth)
        user.put("weight", model.weight.toFloat())
        user.put("height", model.height.toFloat())
        db.collection("users").document(auth.currentUser?.email!!).update(user)
    }
}