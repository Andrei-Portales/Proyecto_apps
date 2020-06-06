package com.portales.proyecto_apps.principal.ajustes

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentAjustesBinding
import com.portales.proyecto_apps.databinding.FragmentLoginBinding
import com.portales.proyecto_apps.login.loginfragment.LoginModel
import com.portales.proyecto_apps.login.loginfragment.LoginViewModel


class ajustesFragment : Fragment() {

    private val auth = FirebaseAuth.getInstance()
    private val currentUser = auth.currentUser
    private lateinit var binding : FragmentAjustesBinding
    private lateinit var viewModel: AjustesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ajustes, container, false)
        activity?.title = activity?.getString(R.string.Ajustes)
        binding.ajustesModel = AjustesModel(currentUser?.displayName!!, currentUser.email!!)
        viewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application as Application).create(AjustesViewModel::class.java)

        Glide.with(context as Activity).load(R.drawable.logoapp).into(binding.profileImage)


        return binding.root
    }

}