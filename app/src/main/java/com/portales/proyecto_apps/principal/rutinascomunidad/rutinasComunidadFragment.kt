package com.portales.proyecto_apps.principal.rutinascomunidad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentRutinasComunidadBinding

class rutinasComunidadFragment : Fragment() {
    private lateinit var viewModel: RutinasComunidadViewModel
    private lateinit var viewModelFactory: RutinasComunidadViewModelFactory
    private lateinit var binding: FragmentRutinasComunidadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentRutinasComunidadBinding>(
            inflater,
            R.layout.fragment_rutinas_comunidad, container, false
        )
        val application = requireNotNull(this.activity).application

        viewModelFactory = RutinasComunidadViewModelFactory(application)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(RutinasComunidadViewModel::class.java)

        //Aqui ira la variable del binding con el xml

        binding.lifecycleOwner = this

        //aqui ira el adapter del recycler

        activity?.title = activity?.getString(R.string.rutinas_comunidad)
        return binding.root
    }

}