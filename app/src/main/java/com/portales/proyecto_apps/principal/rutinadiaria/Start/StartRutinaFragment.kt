package com.portales.proyecto_apps.principal.rutinadiaria.Start

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portales.proyecto_apps.R

class StartRutinaFragment : Fragment() {

    companion object {
        fun newInstance() = StartRutinaFragment()
    }

    private lateinit var viewModel: StartRutinaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.start_rutina_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StartRutinaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}