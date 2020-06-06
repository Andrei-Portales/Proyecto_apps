package com.portales.proyecto_apps.principal.rutinascomunidad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portales.proyecto_apps.R

class rutinasComunidadFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.rutinas_comunidad)
        return inflater.inflate(R.layout.fragment_rutinas_comunidad, container, false)
    }

}