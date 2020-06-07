package com.portales.proyecto_apps.principal.ajustes.updateinfo

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.principal.MainActivity

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
        model: UpdateInfoModel,
        progressInfoChange: ProgressBar,
        btnRegistrarseChange: Button
    ) {
        btnRegistrarseChange.visibility = View.GONE
        progressInfoChange.visibility = View.VISIBLE
        val user = HashMap<String, Any?>()
        user.put("name", model.name)
        user.put("birth", model.birth)
        user.put("weight", model.weight.toFloat())
        user.put("height", model.height.toFloat())
        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(model.name.toString())
            .build()
        auth.currentUser?.updateProfile(profileUpdates)?.addOnCompleteListener {
            if (it.isSuccessful){
                db.collection("users").document(auth.currentUser?.email!!).update(user).addOnCompleteListener {
                    if (it.isSuccessful){
                        btnRegistrarseChange.visibility = View.VISIBLE
                        progressInfoChange.visibility = View.GONE
                        findNavController.navigate(R.id.action_updateInfoFragment_to_ajustesFragment)
                        Toast.makeText(context, "Los datos se actualizaron correctamente", Toast.LENGTH_SHORT).show()
                        (context as MainActivity).updateUI(R.drawable.logoapp)
                    }else{
                        Toast.makeText(context, "No se pudo actualizar los datos", Toast.LENGTH_SHORT).show()
                        btnRegistrarseChange.visibility = View.VISIBLE
                        progressInfoChange.visibility = View.GONE
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "No se pudo actualizar los datos", Toast.LENGTH_SHORT).show()
                    btnRegistrarseChange.visibility = View.VISIBLE
                    progressInfoChange.visibility = View.GONE
                }
            }else{
                Toast.makeText(context, "No se pudo actualizar los datos", Toast.LENGTH_SHORT).show()
                btnRegistrarseChange.visibility = View.VISIBLE
                progressInfoChange.visibility = View.GONE
            }
        }?.addOnFailureListener {
            Toast.makeText(context, "No se pudo actualizar los datos", Toast.LENGTH_SHORT).show()
            btnRegistrarseChange.visibility = View.VISIBLE
            progressInfoChange.visibility = View.GONE
        }

    }


}