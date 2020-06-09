package com.portales.proyecto_apps.principal.inicio

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
import com.portales.proyecto_apps.databinding.FragmentAjustesBinding
import com.portales.proyecto_apps.databinding.FragmentInicioBinding
import com.portales.proyecto_apps.principal.ajustes.AjustesViewModel
import com.portales.proyecto_apps.principal.ajustes.updateinfo.UpdateInfoModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

class inicioFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding : FragmentInicioBinding
    private lateinit var viewModel: InicioViewModel
    private lateinit var dataList :List<RutinaModel>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.Inicio)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_inicio, container, false)
        viewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application as Application).create(InicioViewModel::class.java)
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