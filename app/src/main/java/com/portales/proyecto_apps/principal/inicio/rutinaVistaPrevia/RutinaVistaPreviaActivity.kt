package com.portales.proyecto_apps.principal.inicio.rutinaVistaPrevia

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Space
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.principal.inicio.InicioRecyclerAdapter
import com.portales.proyecto_apps.principal.inicio.InicioViewModel
import com.portales.proyecto_apps.principal.publicacionmodel.EjercicioModel
import com.portales.proyecto_apps.principal.publicacionmodel.IElemento
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import kotlinx.android.synthetic.main.activity_rutina_vista_previa.*
import kotlinx.android.synthetic.main.ejercicio_model.view.*


class RutinaVistaPreviaActivity : AppCompatActivity() {
    private var data :RutinaModel = RutinaModel()
    private lateinit var viewModel: VistaPreviaViewModel
    private var adapter : EjerciciosRecyclerAdapter? = EjerciciosRecyclerAdapter(this, data.exercises)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutina_vista_previa)
        viewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(VistaPreviaViewModel::class.java)
        this.title = "Vista previa de rutina"
        data.createFromMap(intent.extras?.get("data") as HashMap<String, Any?>)
        val s = "%.2f".format(data.time)

        txtTituloRutina.text = data.title
        txtDescripcionRutina.text = data.description
        txtTiempoRutina.text = s
        txtUsuarioRutina.text = data.user

        setRecycler()

    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }



    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_fav_item -> {
                setFav()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setRecycler(){
        testRecycler.setLayoutManager(LinearLayoutManager(this))
        testRecycler.adapter = adapter
    }

    private fun setFav(){
        viewModel.setFav(data.id, this)
    }







}