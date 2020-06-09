package com.portales.proyecto_apps.principal.inicio

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.principal.inicio.rutinaVistaPrevia.RutinaVistaPreviaActivity
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import kotlinx.android.synthetic.main.rutina_model_recycler_inicio.view.*

class InicioRecyclerAdapter(val context:Context,var lista:List<RutinaModel>) :
    RecyclerView.Adapter<InicioRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){
        var pos = 0
        fun create(position: Int){
            pos = position
            val model = lista.get(pos)
            view.tituloRecycler.text = model.title
            view.txtUsuarioRecycler.text = model.user
            val s = "%.2f".format(model.time)
            view.txttiempoRecycler.text = s + " Minutos"
            accion()
        }

        fun accion(){
            view.layout_recyler.setOnClickListener {
                val intent = Intent(context, RutinaVistaPreviaActivity::class.java)
                val element = lista.get(pos).getMap()
                intent.putExtra("data", element)
                (context as Activity).startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.rutina_model_recycler_inicio, parent, false)
        return MyViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.create(position)
    }

}