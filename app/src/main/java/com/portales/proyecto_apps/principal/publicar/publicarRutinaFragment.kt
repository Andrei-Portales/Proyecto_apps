package com.portales.proyecto_apps.principal.publicar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portales.proyecto_apps.R


class publicarRutinaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.PublicarRutina)
        return inflater.inflate(R.layout.fragment_publicar_rutina, container, false)
    }


}