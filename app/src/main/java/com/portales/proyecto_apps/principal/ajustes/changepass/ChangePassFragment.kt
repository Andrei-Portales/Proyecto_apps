package com.portales.proyecto_apps.principal.ajustes.changepass

import android.app.Application
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentChangePassBinding


class ChangePassFragment : Fragment() {

    private lateinit var binding : FragmentChangePassBinding
    private lateinit var viewModel: ChangePassViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.change_pass)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_pass, container,
            false)
        binding.changeModel = ChangePassModel()
        viewModel =  ViewModelProvider.
        AndroidViewModelFactory.getInstance(activity?.application as Application)
            .create(ChangePassViewModel::class.java)
        botones()
        binding.progressChangepass.getIndeterminateDrawable()
            .setColorFilter(context?.getColor(R.color.colorPrimary)!!, PorterDuff.Mode.SRC_IN)
        binding.progressChangepass.visibility = View.GONE
        return binding.root
    }

    fun botones(){
        binding.btnConfirmChange.setOnClickListener {
            if (binding.changeModel!!.isOk()){
                viewModel.changePass(context, binding.changeModel!!, binding.btnConfirmChange,
                    binding.progressChangepass, Navigation.findNavController(binding.root))
            }else{
                Toast.makeText(context, "Contraseña tienen que coincidir y ser " +
                        "mayores o iguales a 8 caracteres", Toast.LENGTH_SHORT).show()
            }
        }
    }


}