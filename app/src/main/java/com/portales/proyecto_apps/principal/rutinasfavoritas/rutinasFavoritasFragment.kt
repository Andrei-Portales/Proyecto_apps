package com.portales.proyecto_apps.principal.rutinasfavoritas

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentInicioBinding
import com.portales.proyecto_apps.databinding.FragmentRutinasFavoritasBinding
import com.portales.proyecto_apps.principal.inicio.InicioRecyclerAdapter
import com.portales.proyecto_apps.principal.inicio.InicioViewModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel


class rutinasFavoritasFragment : Fragment() {

    private lateinit var binding : FragmentRutinasFavoritasBinding
    private lateinit var viewModel: RutinasFavoritasViewModel
    private lateinit var dataList :List<RutinaModel>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.RutinasFavs)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rutinas_favoritas, container, false)
        viewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application as Application).create(RutinasFavoritasViewModel::class.java)
        binding.lifecycleOwner = this
        binding.recyclerInicio.setLayoutManager(LinearLayoutManager(context))
        getData()
        botones()
        return binding.root
    }

    private fun botones(){
        binding.refreshInicio.setOnRefreshListener {
            getData()
        }
    }

    private fun getData(){
        val modelLiveData : LiveData<List<RutinaModel>> = viewModel.getData()
        modelLiveData.observe(binding.lifecycleOwner!!, object: Observer<List<RutinaModel>> {
            override fun onChanged(t: List<RutinaModel>?) {
                dataList = t!!
                if (dataList.size == 0){
                    Toast.makeText(context, "No se encontraron resultados", Toast.LENGTH_LONG).show()
                }
                binding.recyclerInicio.adapter = InicioRecyclerAdapter(context as Context, dataList)
                binding.refreshInicio.isRefreshing = false
            }
        })
    }



}