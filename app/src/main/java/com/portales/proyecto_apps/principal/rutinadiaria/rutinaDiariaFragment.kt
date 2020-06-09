package com.portales.proyecto_apps.principal.rutinadiaria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentRutinaDiariaBinding
import java.text.SimpleDateFormat
import java.util.*

class rutinaDiariaFragment : Fragment() {

    companion object{
        fun newInstance() = rutinaDiariaFragment()
    }

    private lateinit var viewModel: RutinaDiariaViewModel
    private lateinit var binding: FragmentRutinaDiariaBinding

    private var currentTime: Date = Calendar.getInstance().time
    private var currentDay: Calendar = Calendar.getInstance()
    private var day: Int = currentDay.get(Calendar.DAY_OF_WEEK)

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

        val format = SimpleDateFormat("dd/MM/yyyy")
        val date = format.format(currentTime.getTime())


        binding.dateText.text = date.toString()

        binding.IrRutinaComunidad

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(RutinaDiariaViewModel::class.java)


    }

}