package com.portales.proyecto_apps.principal.publicar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentPublicarRutinaBinding


class publicarRutinaFragment : Fragment() {
    private lateinit var binding: FragmentPublicarRutinaBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.PublicarRutina)
        binding = DataBindingUtil.inflate<FragmentPublicarRutinaBinding>(
            inflater,
            R.layout.fragment_publicar_rutina, container, false
        )

        //Por si se desea implementar livedata
        binding.lifecycleOwner = this


        return binding.root
    }


}