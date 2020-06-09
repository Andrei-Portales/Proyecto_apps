package com.portales.proyecto_apps.principal.rutinadiaria.Start

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentRutinaDiariaBinding
import com.portales.proyecto_apps.databinding.StartRutinaFragmentBinding
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import java.util.*

class StartRutinaFragment : Fragment() {

    companion object {
        fun newInstance() = StartRutinaFragment()
    }

    private lateinit var viewModel: StartRutinaViewModel
    private lateinit var binding: StartRutinaFragmentBinding
    private lateinit var data: List<RutinaModel>


    private var currentDay: Calendar = Calendar.getInstance()
    private var day: Int = currentDay.get(Calendar.DAY_OF_WEEK)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.start_rutina_fragment,
            container,
            false
        )

        val modelLiveData : LiveData<List<RutinaModel>> = viewModel.getModel()

        if(day == Calendar.MONDAY){

        }else if (day == Calendar.TUESDAY){

        }else if (day == Calendar.WEDNESDAY){

        }else if (day == Calendar.THURSDAY){

        }else if (day == Calendar.FRIDAY){

        }else if (day == Calendar.SATURDAY){

        }else{

        }

        /*binding.button.setOnClickListener{
            requireView().findNavController().navigate(StartRutinaFragmentDirections.actionStartRutinaFragmentToRutinaDiariaFragment())
        }*/


        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StartRutinaViewModel::class.java)

    }

}