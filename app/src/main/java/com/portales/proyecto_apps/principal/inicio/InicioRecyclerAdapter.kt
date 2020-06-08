package com.portales.proyecto_apps.principal.inicio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import kotlinx.android.synthetic.main.rutina_model_recycler_inicio.view.*

class InicioRecyclerAdapter(val context:Context,var lista:List<RutinaModel>) :
    RecyclerView.Adapter<InicioRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){
        fun create(position: Int){
            val model = lista.get(position)
            view.tituloRecycler.text = model.title
            view.txtUsuarioRecycler.text = model.user
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