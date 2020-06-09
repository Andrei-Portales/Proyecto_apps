package com.portales.proyecto_apps.principal.preview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class PreviewRoutineViewModel(application: Application, dato: String):AndroidViewModel(application) {
    val repository = PreviewRoutineRepository()

    val rutina = repository.obtenerRutina(dato)
    private val _routine = MutableLiveData<RutinaModel>(rutina)
    val routine: LiveData<RutinaModel>
        get()=_routine



}