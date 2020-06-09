package com.portales.proyecto_apps.principal.inicio.rutinaVistaPrevia

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Space
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.principal.publicacionmodel.EjercicioModel
import com.portales.proyecto_apps.principal.publicacionmodel.IElemento
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import kotlinx.android.synthetic.main.activity_rutina_vista_previa.*
import kotlinx.android.synthetic.main.ejercicio_model.view.*


class RutinaVistaPreviaActivity : AppCompatActivity() {
    private var data :RutinaModel = RutinaModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutina_vista_previa)
        this.title = "Vista previa de rutina"
        data.createFromMap(intent.extras?.get("data") as HashMap<String, Any?>)
        val s = "%.2f".format(data.time)

        txtTituloRutina.text = data.title
        txtDescripcionRutina.text = data.description
        txtTiempoRutina.text = s
        txtUsuarioRutina.text = data.user

        setRecycler()
    }

    private fun setRecycler(){
        testRecycler.setLayoutManager(LinearLayoutManager(this))
        testRecycler.adapter = EjerciciosRecyclerAdapter(this, data.exercises)
    }






}