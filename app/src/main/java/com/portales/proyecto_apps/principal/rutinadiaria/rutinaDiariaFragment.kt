package com.portales.proyecto_apps.principal.rutinadiaria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portales.proyecto_apps.R

class rutinaDiariaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.RutinaDiaria)
        return inflater.inflate(R.layout.fragment_rutina_diaria, container, false)
    }

}