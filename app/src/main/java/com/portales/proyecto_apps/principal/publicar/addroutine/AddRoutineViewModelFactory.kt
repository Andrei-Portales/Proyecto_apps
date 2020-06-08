package com.portales.proyecto_apps.principal.publicar.addroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class AddRoutineViewModelFactory ():ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddRoutineViewModel::class.java)){
            return AddRoutineViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}