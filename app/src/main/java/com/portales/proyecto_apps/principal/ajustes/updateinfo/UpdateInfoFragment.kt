package com.portales.proyecto_apps.principal.ajustes.updateinfo

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
import com.portales.proyecto_apps.databinding.FragmentUpdateInfoBinding
import com.portales.proyecto_apps.principal.ajustes.AjustesViewModel

class UpdateInfoFragment : Fragment() {

    private lateinit var binding : FragmentUpdateInfoBinding
    private lateinit var viewModel: UpdateViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.update_info)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update_info, container, false)
        viewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application as Application).create(UpdateViewModel::class.java)
        binding.lifecycleOwner = this
        // Inflate the layout for this fragment
        return binding.root
    }

}