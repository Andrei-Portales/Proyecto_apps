package com.portales.proyecto_apps.principal.rutinascomunidad

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RutinasComunidadViewModelFactory(
    private val application: Application,
    private val busqueda: String
) :ViewModelProvider.Factory{


    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RutinasComunidadViewModel::class.java)){
            return RutinasComunidadViewModel(application,busqueda) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}