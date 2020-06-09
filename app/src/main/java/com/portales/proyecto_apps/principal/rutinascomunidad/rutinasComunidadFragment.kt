package com.portales.proyecto_apps.principal.rutinascomunidad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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
        binding.rutinasComunidadViewModel = viewModel
       // binding.lifecycleOwner = this

        //aqui ira el adapter del recycler
        val adapter = RutinasComunidadAdapter(RutinaModelListener { routineId ->
            Toast.makeText(context, "${routineId}", Toast.LENGTH_LONG).show()
        })
        binding.recyclerViewComunidad.adapter =adapter

        viewModel._routinesList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        binding.setLifecycleOwner(this)
        binding.searchRoutinesButton.setOnClickListener {

        }

        activity?.title = activity?.getString(R.string.rutinas_comunidad)
        return binding.root
    }

}