package com.portales.proyecto_apps.principal.rutinascomunidad

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import kotlinx.coroutines.*

class RutinasComunidadViewModel (application: Application): AndroidViewModel(application){

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +viewModelJob)
    private val repository = RutinasComunidadRepository()

    private val _routinesList = repository.getData()
    val routinesList: LiveData<List<RutinaModel>>
        get()=_routinesList

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()

    }

    fun busquedaRutinas(resultado: String){
        uiScope.launch {
            selectByQuery(resultado)
        }

    }




    private suspend fun selectByQuery(query: String){
        withContext(Dispatchers.IO){
            val listadoRaw = repository.getData().value
            val listadoResult :MutableList<RutinaModel> = mutableListOf()
            if (query.isEmpty()){
                _routinesList.value = listadoRaw
            }
            else {
                if (listadoRaw != null) {
                    for (rutina in listadoRaw) {
                        if (rutina.title.contains(query, ignoreCase = true)) {
                            listadoResult.add(rutina)
                        }
                    }
                    if(listadoResult.isNullOrEmpty()){
                        _routinesList.value = listOf()
                    }
                    else{
                        _routinesList.value = listadoResult.toList()
                    }
                }
            }


        }

    }
}