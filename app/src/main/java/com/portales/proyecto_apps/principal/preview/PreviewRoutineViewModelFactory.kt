package com.portales.proyecto_apps.principal.preview

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("unchecked_cast")
class PreviewRoutineViewModelFactory(private val application: Application, private val busqueda: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreviewRoutineViewModel::class.java)){
            return PreviewRoutineViewModel(application,busqueda) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}