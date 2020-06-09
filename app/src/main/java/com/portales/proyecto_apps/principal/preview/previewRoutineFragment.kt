package com.portales.proyecto_apps.principal.preview

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentPreviewRoutineBinding
import com.portales.proyecto_apps.principal.inicio.rutinaVistaPrevia.RutinaVistaPreviaActivity
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import kotlinx.android.synthetic.main.rutina_model_recycler_inicio.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [previewRoutineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class previewRoutineFragment : Fragment() {
    private lateinit var viewModel: PreviewRoutineViewModel
    private lateinit var viewModelFactory: PreviewRoutineViewModelFactory
    private lateinit var binding: FragmentPreviewRoutineBinding
    private lateinit var dataList: RutinaModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentPreviewRoutineBinding>(
            inflater,
            R.layout.fragment_preview_routine,container,false
        )
        val application = requireNotNull(this.activity).application

        val idDelObjeto = previewRoutineFragmentArgs.fromBundle(requireArguments()).selectedRoutineId
        viewModelFactory = PreviewRoutineViewModelFactory(application,idDelObjeto)
       // Toast.makeText(context, idDelObjeto, Toast.LENGTH_LONG)
           // .show()

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(PreviewRoutineViewModel::class.java)


        binding.previewRoutine = viewModel
        binding.lifecycleOwner = this
        getData()
        binding.buttonGotoAddRoutine.setOnClickListener{
            //AquiLanzo el intent
            accion()
        }

         return binding.root
    }
    private fun accion(){
            val intent = Intent(context, RutinaVistaPreviaActivity::class.java)
            val element = dataList.getMap()
            intent.putExtra("data", element)
            (context as Activity).startActivity(intent)

    }

    private fun getData(){
        val modelLiveData: LiveData<RutinaModel> = viewModel.getData()
        modelLiveData.observe(binding.lifecycleOwner!!, object: Observer<RutinaModel>{
            @SuppressLint("SetTextI18n")
            override fun onChanged(t: RutinaModel?) {

                dataList = t!!
                binding.routinePreviewTitle.text = dataList.title
                binding.routineDescriptionPreview.text = dataList.description
                binding.authorNamePreview.text = dataList.user

                binding.imageRoutineIntensityPreview.setImageResource(when {
                    dataList.time.toFloat()>=40 -> {
                        R.drawable.routine_intensity_3
                    }
                    dataList.time.toFloat()>=20 -> {
                        R.drawable.routine_intensity_2
                    }

                    else -> {
                        R.drawable.routine_intensity_1
                    }
                })

                var texto_ejercicio =""
                for (ejer in dataList.exercises){
                    texto_ejercicio += ejer.title+"\n"+ejer.description+"\n\n"
                }
                binding.excercisesPreview.text = texto_ejercicio

                binding.routineDurationPreview.text = "Duracion: "+dataList.time.toInt()+"min"


            }

        })
    }
}

