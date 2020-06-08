package com.portales.proyecto_apps.principal.publicar.addroutine

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class AddRoutineViewModel(): ViewModel() {
    lateinit var repository: AddRoutineRepository
    init {
        Log.i("AddRoutineViewModel","AddRoutineViewModel CREATED")
        repository = AddRoutineRepository()
    }

    fun agregarRutina(model: RutinaModel, context: Context){
        repository.putRoutine(model,context)

    }
}