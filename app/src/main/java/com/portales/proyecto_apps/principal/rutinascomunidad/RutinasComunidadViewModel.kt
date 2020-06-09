package com.portales.proyecto_apps.principal.rutinascomunidad

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import kotlinx.coroutines.*

class RutinasComunidadViewModel (application: Application, query: String): AndroidViewModel(application){

    //private var viewModelJob = Job()
    //private val uiScope = CoroutineScope(Dispatchers.Main +viewModelJob)
    private val repository = RutinasComunidadRepository()

     val _routinesList = busquedaRutinas(query)
     val routinesList: LiveData<List<RutinaModel>>
        get()=_routinesList


    override fun onCleared() {
        super.onCleared()
        //viewModelJob.cancel()

    }

    init {

    }

    private fun busquedaRutinas(busqueda: String): MutableLiveData<List<RutinaModel>> {
        if (busqueda ==""){
            return repository.getData()
        }
        else{
            return repository.getDataQuery(busqueda)
        }




    }





}

