package com.portales.proyecto_apps.principal.rutinascomunidad

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel


@BindingAdapter("routineName")
fun TextView.setRoutineName(item: RutinaModel){
    text = item.title
}

@BindingAdapter("intensityImage")
fun ImageView.setIntensityImage(item: RutinaModel){
    setImageResource(when {
        item.time.toFloat()>=40 -> {
            R.drawable.routine_intensity_3
        }
        item.time.toFloat()>=20 -> {
            R.drawable.routine_intensity_2
        }

        else -> {
            R.drawable.routine_intensity_1
        }
    })
}

@SuppressLint("SetTextI18n")
@BindingAdapter("routineDuration")
fun TextView.setRoutineDuration(item: RutinaModel){
    text = "Duracion: ${item.time.toInt()} Minutos"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("userCreated")
fun TextView.setUserCreated(item: RutinaModel){
    text = "Creador: ${item.user}"
}
@BindingAdapter("routineDescription")
fun TextView.setRoutineDescription(item: RutinaModel){
    text = item.description
}


