package com.portales.proyecto_apps.principal.publicar.addroutine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.AddEjercicioModelBinding
import com.portales.proyecto_apps.principal.inicio.InicioRecyclerAdapter
import com.portales.proyecto_apps.principal.publicacionmodel.EjercicioModel

class AddRoutineRecyclerAdapter( var context: Context, var list:List<EjercicioModel>) :
    RecyclerView.Adapter<AddRoutineRecyclerAdapter.MyViewHolder>(){

    inner class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){

        lateinit var binding: AddEjercicioModelBinding

        var pos = 0
        fun create(position: Int){
            pos = position
            binding = DataBindingUtil.bind(view)!!
            binding.data = list.get(pos)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.add_ejercicio_model, parent, false)
        return MyViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.create(position)
    }
}