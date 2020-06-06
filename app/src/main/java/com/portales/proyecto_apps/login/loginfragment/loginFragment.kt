package com.portales.proyecto_apps.login.loginfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.principal.MainActivity
import kotlinx.android.synthetic.main.fragment_login.view.*


class loginFragment : Fragment() {

    private lateinit var vista: View
    private lateinit var listener: View.OnClickListener


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_login, container, false)
        listener = ActionListener()
        activity?.title = activity?.getString(R.string.iniciar_sesion)
        botones()
        return vista
    }

    private fun botones(){
        vista.txtRegistrarse.setOnClickListener(listener)
        vista.btnIniciarSesion.setOnClickListener(listener)
    }



    inner class ActionListener : View.OnClickListener{

        override fun onClick(v: View?) {
            when(v){
                vista.txtRegistrarse -> { //Texto de registrarse
                    Navigation.findNavController(vista).navigate(R.id.action_loginFragment_to_registerFragment)
                }
                vista.btnIniciarSesion -> {
                    startActivity(Intent(context, MainActivity::class.java))
                    activity?.finish()
                }
            }
        }

    }

}
