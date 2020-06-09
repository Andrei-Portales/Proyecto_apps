package com.portales.proyecto_apps.principal.preview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class PreviewRoutineViewModel(application: Application, dato: String):AndroidViewModel(application) {
    val repository = PreviewRoutineRepository()
    lateinit var datos: String

init {
     datos = dato
}
    private val _routine = MutableLiveData<RutinaModel>()
    val routine: LiveData<RutinaModel>
        get()=_routine


    fun getData(): MutableLiveData<RutinaModel>{
        repository.getData(datos).observeForever {
            _routine.value =it
        }
        return _routine
    }
}