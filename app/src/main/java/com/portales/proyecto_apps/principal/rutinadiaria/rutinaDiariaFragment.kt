package com.portales.proyecto_apps.principal.rutinadiaria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentRutinaDiariaBinding
import java.util.*

class rutinaDiariaFragment : Fragment() {

    companion object{
        fun newInstance() = rutinaDiariaFragment()
    }

    private lateinit var viewModel: RutinaDiariaViewModel
    private lateinit var binding: FragmentRutinaDiariaBinding

    var currentTime: Date = Calendar.getInstance().time

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.RutinaDiaria)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_rutina_diaria,
            container,
            false
        )

        binding.dateText.text = currentTime.toString()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(RutinaDiariaViewModel::class.java)


    }

}