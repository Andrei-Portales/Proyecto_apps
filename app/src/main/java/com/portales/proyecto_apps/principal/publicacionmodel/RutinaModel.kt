package com.portales.proyecto_apps.principal.publicacionmodel

data class RutinaModel (var title:String = "", var description:String = "", var time:Float = 0f
                   , var user:String = "", var video:String = "",
                        var exercises:ArrayList<EjercicioModel> = ArrayList()) {

    fun getMap():HashMap<String, Any?>{
        val rutina = HashMap<String, Any?>()
        rutina.put("title", title)
        rutina.put("time", time)
        rutina.put("description", description)
        rutina.put("user", user)
        rutina.put("video", video)

        val exercisesList = ArrayList<HashMap<String, Any?>>()

        for (exercise in exercises){
            val ex = HashMap<String, Any?>()
            ex.put("title", exercise.title)
            ex.put("description", exercise.description)
            ex.put("video", exercise.video)
            exercisesList.add(ex)
        }
        rutina.put("exercises", exercisesList.toArray())
        return rutina
    }

    fun addExercise(title:String, description:String, video:String){
        exercises.add(EjercicioModel(title, description, video))
    }

    fun addExercise(model: EjercicioModel){
        exercises.add(model)
    }
}