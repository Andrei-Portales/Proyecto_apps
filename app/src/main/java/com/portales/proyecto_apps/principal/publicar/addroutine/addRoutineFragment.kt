package com.portales.proyecto_apps.principal.publicar.addroutine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentAddRoutineBinding

/**
 * A simple [Fragment] subclass.
 * Use the [addRoutineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class addRoutineFragment : Fragment() {
    private lateinit var viewModel: AddRoutineViewModel
    private lateinit var viewModelFactory: AddRoutineViewModelFactory
    private lateinit var binding: FragmentAddRoutineBinding

    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentAddRoutineBinding>(
            inflater,
            R.layout.fragment_add_routine,container,false
        )
        viewModelFactory = AddRoutineViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(AddRoutineViewModel::class.java)

        binding.lifecycleOwner = this

        return binding.root
    }
    
}