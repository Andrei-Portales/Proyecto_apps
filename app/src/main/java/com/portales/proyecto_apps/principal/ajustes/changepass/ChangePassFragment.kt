package com.portales.proyecto_apps.principal.ajustes.changepass

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentAjustesBinding
import com.portales.proyecto_apps.databinding.FragmentChangePassBinding
import com.portales.proyecto_apps.principal.ajustes.AjustesModel
import com.portales.proyecto_apps.principal.ajustes.AjustesViewModel


class ChangePassFragment : Fragment() {

    private lateinit var binding : FragmentChangePassBinding
    private lateinit var viewModel: ChangePassViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.change_pass)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_pass, container, false)
        binding.changeModel = ChangePassModel()
        viewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application as Application).create(ChangePassViewModel::class.java)
        botones()
        return binding.root
    }

    fun botones(){
        binding.btnConfirmChange.setOnClickListener {
            if (binding.changeModel.isOk()){

            }
        }
    }


}