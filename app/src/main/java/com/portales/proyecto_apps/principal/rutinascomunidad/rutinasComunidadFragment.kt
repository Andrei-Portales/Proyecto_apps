package com.portales.proyecto_apps.principal.rutinascomunidad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
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
        binding.searchRuotinesTextField.setText(rutinasComunidadFragmentArgs.fromBundle(requireArguments()).stringBusqueda)

        viewModelFactory = RutinasComunidadViewModelFactory(application, binding.searchRuotinesTextField.text.toString())
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(RutinasComunidadViewModel::class.java)


        //Aqui ira la variable del binding con el xml
        binding.rutinasComunidadViewModel = viewModel
       // binding.lifecycleOwner = this

        //aqui ira el adapter del recycler
        val adapter = RutinasComunidadAdapter(RutinaModelListener { routineId ->
            previewDeRutina(routineId)

        })
        binding.recyclerViewComunidad.adapter =adapter

        viewModel._routinesList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        binding.setLifecycleOwner(this)



        binding.searchRoutinesButton.setOnClickListener {
            //PARA BUSQUEDA
            busquedaRecursiva()

        }


        activity?.title = activity?.getString(R.string.rutinas_comunidad)
        return binding.root
    }

    private fun busquedaRecursiva(){
        val action =rutinasComunidadFragmentDirections.actionRutinasComunidadFragmentSelf()
        action.stringBusqueda = binding.searchRuotinesTextField.text.toString()
        view?.findNavController()?.navigate(action)
    }


    private fun previewDeRutina(id: String){
        val action = rutinasComunidadFragmentDirections.actionRutinasComunidadFragmentToPreviewRoutineFragment()

        action.selectedRoutineId = id

        view?.findNavController()?.navigate(action)

    }

}