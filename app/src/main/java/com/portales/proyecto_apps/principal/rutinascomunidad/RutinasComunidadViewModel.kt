package com.portales.proyecto_apps.principal.rutinascomunidad

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import kotlinx.coroutines.*

class RutinasComunidadViewModel (application: Application): AndroidViewModel(application){

    //private var viewModelJob = Job()
    //private val uiScope = CoroutineScope(Dispatchers.Main +viewModelJob)
    private val repository = RutinasComunidadRepository()
    private val Resultado = repository.getDataArrayList()

     val _routinesList = repository.getData()
    val routinesList: LiveData<List<RutinaModel>>
        get()=_routinesList


    override fun onCleared() {
        super.onCleared()
        //viewModelJob.cancel()

    }

    init {

    }

    fun busquedaRutinas(resultado: String){
        _routinesList.value = Resultado.toList()




    }





}

