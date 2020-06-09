package com.portales.proyecto_apps.principal.publicacionmodel

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.QueryDocumentSnapshot

data class RutinaModel (var title:String = "", var description:String = "", var time:Float = 0f
                   , var user:String = "", var video:String = "",
                        var exercises:ArrayList<EjercicioModel> = ArrayList(), var id: String="" )
                                                                                    :IElemento{

    fun isOk() : Boolean{
        return(title.isNotEmpty() && title.isNotBlank() &&
                description.isNotEmpty() && description.isNotBlank() &&
                (time > 0) && exercisesOk() &&
                (exercises.size>0) )
    }

    fun exercisesOk():Boolean{
        var ok = true
        for (ex in exercises){
            var k = ex.title.isNotEmpty() && ex.title.isNotBlank() &&
                    ex.description.isNotEmpty() && ex.description.isNotBlank() &&
                    ex.video.isNotEmpty() && ex.video.isNotBlank()
            if (!k){
                ok = false
            }
        }
        return ok
    }

    fun getMap():HashMap<String, Any?>{
        val rutina = HashMap<String, Any?>()
        rutina.put("title", title)
        rutina.put("time", time)
        rutina.put("description", description)
        rutina.put("user", user)
        rutina.put("video", video)
        rutina.put("id", id)

        val exercisesList = ArrayList<HashMap<String, Any?>>()

        for (exercise in exercises){
            val ex = HashMap<String, Any?>()
            ex.put("title", exercise.title)
            ex.put("description", exercise.description)
            ex.put("video", exercise.video)
            exercisesList.add(ex)
        }
        rutina.put("exercises", exercisesList as List<HashMap<String, Any?>>)
        return rutina
    }

    fun addExercise(title:String, description:String, video:String){
        exercises.add(EjercicioModel(title, description, video))
    }

    fun addExercise(model: EjercicioModel){
        exercises.add(model)
    }

    fun createFromQueryDocumentSnapshot(d:QueryDocumentSnapshot){
        title = d.get("title").toString()
        description =  d.get("description").toString()
        time = d.get("time").toString().toFloat()
        user = d.get("user").toString()
        video =  d.get("video").toString()
        id = d.get("id").toString()
        val listMaps:List<HashMap<String, Any?>> = d.get("exercises") as List<HashMap<String, Any?>>
        for(map in listMaps){
            exercises.add(EjercicioModel(map.get("title").toString(),
                map.get("description").toString(), map.get("video").toString()))
        }
    }

    fun createFromMap(map:HashMap<String, Any?>){
        title = map.get("title").toString()
        time = map.get("time").toString().toFloat()
        description = map.get("description").toString()
        user = map.get("user").toString()
        video = map.get("video").toString()
        id = map.get("id").toString()

        val listaRutinas = map.get("exercises") as List<HashMap<String, Any?>>
        for (rutina in listaRutinas){
            exercises.add(EjercicioModel(rutina.get("title").toString(),
            rutina.get("description").toString(), rutina.get("video").toString()))
        }
    }
}