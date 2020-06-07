package com.portales.proyecto_apps.login.passrecovery

import android.app.Application
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentPasswordRecoveryBinding


class PasswordRecoveryFragment : Fragment() {

    private lateinit var binding : FragmentPasswordRecoveryBinding
    private lateinit var viewModel: RecoveryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.pass_recovery)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_password_recovery, container, false)
        binding.recoveryModel = RecoveryModel()
        viewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application as Application).create(RecoveryViewModel::class.java)
        botones()
        binding.progressRecovery.getIndeterminateDrawable()
            .setColorFilter(context?.getColor(R.color.colorPrimary)!!, PorterDuff.Mode.SRC_IN)
        binding.progressRecovery.visibility = View.GONE
        return binding.root
    }

    private fun botones(){
        binding.txtGoLogin.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_passwordRecoveryFragment_to_loginFragment)
        }
        binding.btnRecovery.setOnClickListener {
            viewModel.recovery(binding.recoveryModel!!, binding.progressRecovery, binding.btnRecovery, context, Navigation.findNavController(binding.root))
        }
    }




}