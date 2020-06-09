package com.portales.proyecto_apps.principal.rutinasfavoritas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.principal.inicio.InicioRecyclerAdapter
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import kotlinx.android.synthetic.main.rutina_model_recycler_inicio.view.*

// class RutinasFavoritasRecyclerAdapter(val context: Context, var lista:List<RutinaModel>):
// RecyclerView.Adapter<InicioRecyclerAdapter.MyViewHolder>() {
//
// inner class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){
// fun create(position: Int){
// val model = lista.get(position)
// view.tituloRecycler.text = model.title
// view.txtUsuarioRecycler.text = model.user
// val s = "%.2f".format(model.time)
// view.txttiempoRecycler.text = s + " Minutos"
// }
// }
//
//
// override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InicioRecyclerAdapter.MyViewHolder {
// val vista = LayoutInflater.from(parent.context)
// .inflate(R.layout.rutina_model_recycler_inicio, parent, false)
// return InicioRecyclerAdapter.MyViewHolder(vista)
// }
//
// override fun getItemCount(): Int {
// return lista.size
// }
//
// override fun onBindViewHolder(holder: InicioRecyclerAdapter.MyViewHolder, position: Int) {
// holder.create(position)
// }
//
// }