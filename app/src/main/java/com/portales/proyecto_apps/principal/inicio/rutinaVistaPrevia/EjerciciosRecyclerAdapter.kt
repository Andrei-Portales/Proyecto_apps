package com.portales.proyecto_apps.principal.inicio.rutinaVistaPrevia

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.principal.inicio.InicioRecyclerAdapter
import com.portales.proyecto_apps.principal.publicacionmodel.EjercicioModel
import kotlinx.android.synthetic.main.ejercicio_model.view.*
import kotlinx.android.synthetic.main.rutina_model_recycler_inicio.view.*
import java.lang.Exception

class EjerciciosRecyclerAdapter(var context: Context, var list:List<EjercicioModel>) :
    RecyclerView.Adapter<EjerciciosRecyclerAdapter.MyViewHolder>(){

    inner class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){
        var pos = 0
        fun create(position: Int){
            pos = position
            val model = list.get(pos)
            view.txtEjercicioName.text = model.title
            view.txtDescripcionR.text = model.description
            createYoutube(model.video)
        }

        private fun createYoutube(url:String){
            try{
                val videoId = YouTubeHelper.getVideoId(url).toString()
                view.youtubeVideo.addYouTubePlayerListener(object: AbstractYouTubePlayerListener(){
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        super.onReady(youTubePlayer)
                        youTubePlayer.loadVideo(videoId,0f)
                    }
                })
            }catch (e:Exception){
                view.youtubeVideo.visibility = View.GONE
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.ejercicio_model, parent, false)
        return MyViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.create(position)
    }


}