package com.portales.proyecto_apps.principal.ajustes.updateinfo

import android.app.Application
import android.app.DatePickerDialog
import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentUpdateInfoBinding
import java.util.*

class UpdateInfoFragment : Fragment() , DatePickerDialog.OnDateSetListener{

    private lateinit var binding : FragmentUpdateInfoBinding
    private lateinit var viewModel: UpdateViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = activity?.getString(R.string.update_info)
        binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_update_info, container, false)
        viewModel =  ViewModelProvider.AndroidViewModelFactory
            .getInstance(activity?.application as Application).create(UpdateViewModel::class.java)
        binding.lifecycleOwner = this
        binding.btnRegistrarseChange.visibility = View.GONE
        binding.progressInfoChange.getIndeterminateDrawable()
            .setColorFilter(context?.getColor(R.color.colorPrimary)!!, PorterDuff.Mode.SRC_IN)
        binding.progressInfoChange.visibility = View.VISIBLE
        setbutons()
        getModel()
        return binding.root
    }

    fun setbutons(){
        binding.swipeToRefreshUpdateInfo.setOnRefreshListener {
            binding.progressInfoChange.visibility = View.VISIBLE
            getModel()
        }
        binding.btnRegistrarseChange.setOnClickListener {
            if (binding.updateInfoModel!!.areEmpty()){
                if (binding.updateInfoModel!!.areNumbers()){
                    viewModel.change(context, Navigation.findNavController(binding.root), binding.updateInfoModel!!)
                }else{
                    Snackbar.make(binding.root, "Campos numericos no validos", Snackbar.LENGTH_SHORT).show()
                }
            }else{
                Snackbar.make(binding.root, "Campos vacios", Snackbar.LENGTH_SHORT).show()
            }
        }
        binding.txtFechaLayoutChange.setOnClickListener {
            val date = binding.updateInfoModel!!.birth.split("/")
            DatePickerDialog(context as Context, this,
                date.get(2).toInt(),
                date.get(1).toInt(),
                date.get(0).toInt()).show()
        }
    }

    fun getModel(){
        val modelLiveData :LiveData<UpdateInfoModel> = viewModel.getModel()
        modelLiveData.observe(binding.lifecycleOwner!!, object: Observer<UpdateInfoModel>{
            override fun onChanged(t: UpdateInfoModel?) {
                binding.apply {
                    updateInfoModel = t
                    progressInfoChange.visibility = View.GONE
                    if (!(t?.isEmpty()!!)){
                        btnRegistrarseChange.visibility = View.VISIBLE
                    }else{
                        binding.btnRegistrarseChange.visibility = View.GONE
                        Toast.makeText(context, "No se pudo obtener la informacion", Toast.LENGTH_SHORT).show()
                    }
                    swipeToRefreshUpdateInfo.isRefreshing = false
                }
            }
        })

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        binding.txtFechaNacimientoChange.setText("${dayOfMonth}/${month}/${year}")
    }

}