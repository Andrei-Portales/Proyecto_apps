package com.portales.proyecto_apps.login.loginfragment

import android.app.Application
import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentLoginBinding


class loginFragment : Fragment() {


    private lateinit var listener: View.OnClickListener
    private lateinit var binding : FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.loginModel = LoginModel()
        viewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application as Application).create(LoginViewModel::class.java)
        listener = ActionListener()
        activity?.title = activity?.getString(R.string.iniciar_sesion)
        botones()
        binding.progressLogin.getIndeterminateDrawable()
            .setColorFilter(context?.getColor(R.color.colorPrimary)!!, PorterDuff.Mode.SRC_IN)
        binding.progressLogin.visibility = View.GONE
        return binding.root
    }

    private fun botones(){
        binding.txtRegistrarse.setOnClickListener(listener)
        binding.btnIniciarSesion.setOnClickListener(listener)
    }


    inner class ActionListener : View.OnClickListener{

        override fun onClick(v: View?) {
            when(v){
                binding.txtRegistrarse -> { //Texto de registrarse
                    Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_registerFragment)
                }
                binding.btnIniciarSesion -> {
                    if (binding.loginModel!!.isnotEmpty()){
                        binding.progressLogin.visibility = View.VISIBLE
                        binding.btnIniciarSesion.visibility = View.GONE
                        viewModel.Login(binding.loginModel!!, context as Context, binding.progressLogin, binding.btnIniciarSesion)
                    }else{
                        Snackbar.make(binding.root, "Campos vacios", Snackbar.LENGTH_SHORT).show()
                    }

                }
            }
        }

    }

}
