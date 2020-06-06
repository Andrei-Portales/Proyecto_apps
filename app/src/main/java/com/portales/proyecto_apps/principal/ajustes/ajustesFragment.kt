package com.portales.proyecto_apps.principal.ajustes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portales.proyecto_apps.R


class ajustesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.Ajustes)
        return inflater.inflate(R.layout.fragment_ajustes, container, false)
    }

}