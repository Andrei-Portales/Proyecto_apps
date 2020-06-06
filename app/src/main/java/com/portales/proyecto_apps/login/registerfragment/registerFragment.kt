package com.portales.proyecto_apps.login.registerfragment

import android.app.Application
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentRegisterBinding
import java.util.*


class registerFragment : Fragment() , DatePickerDialog.OnDateSetListener {


        private lateinit var listener: View.OnClickListener
        private val dateListener :  DatePickerDialog.OnDateSetListener = this
        private lateinit var binding : FragmentRegisterBinding
        private lateinit var viewModel: RegisterViewModel


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
            binding.registerModel = RegisterModel()
            activity?.title = activity?.getString(R.string.registrarse)
            listener = ActionListener()
            botones()
            viewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application as Application).create(RegisterViewModel::class.java)
            return binding.root
        }



        private fun botones(){
            binding.txtFechaLayout.setOnClickListener(listener)
            binding.txtYaCuenta.setOnClickListener(listener)
            binding.btnRegistrarse.setOnClickListener(listener)
        }


        inner class ActionListener() : View.OnClickListener {
            override fun onClick(v: View?) {
                when(v){
                    binding.txtFechaLayout -> {
                        DatePickerDialog(context as Context, dateListener,
                            Calendar.getInstance().get(Calendar.YEAR),
                            Calendar.getInstance().get(Calendar.MONTH),
                            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show()
                    }
                    binding.txtYaCuenta -> {
                        Navigation.findNavController(binding.root).navigate(R.id.action_registerFragment_to_loginFragment)
                    }
                    binding.btnRegistrarse -> {
                        if (binding.registerModel!!.areEmpty()){
                            if (binding.registerModel!!.passLength()){
                                if(binding.registerModel!!.comparePasswords()){
                                    if (binding.registerModel!!.areNumbers()){
                                        viewModel.register(binding.registerModel!!, context as Context,  Navigation.findNavController(binding.root))
                                    }else{
                                        Snackbar.make(binding.root, "Campos numericos no validos", Snackbar.LENGTH_SHORT).show()
                                    }
                                }else{
                                    Snackbar.make(binding.root, "Contaseñas no coinciden", Snackbar.LENGTH_SHORT).show()
                                }
                            }else{
                                Snackbar.make(binding.root, "Contaseña tiene que ser de 8 o mas caracteres", Snackbar.LENGTH_SHORT).show()
                            }
                        }else{
                            Snackbar.make(binding.root, "Campos vacios", Snackbar.LENGTH_SHORT).show()
                        }
                    }

                }
            }


        }



        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
            binding.txtFechaNacimiento.setText("${dayOfMonth}/${month}/${year}")
        }




    }
