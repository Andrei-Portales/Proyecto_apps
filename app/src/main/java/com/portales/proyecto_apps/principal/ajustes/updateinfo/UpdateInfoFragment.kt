package com.portales.proyecto_apps.principal.ajustes.updateinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portales.proyecto_apps.R

class UpdateInfoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.update_info)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_info, container, false)
    }

}