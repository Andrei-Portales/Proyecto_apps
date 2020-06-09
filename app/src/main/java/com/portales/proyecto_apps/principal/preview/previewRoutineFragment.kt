package com.portales.proyecto_apps.principal.preview

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
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

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
        Toast.makeText(context, idDelObjeto, Toast.LENGTH_LONG)
            .show()

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(PreviewRoutineViewModel::class.java)


        binding.previewRoutine = viewModel
        binding.lifecycleOwner = this


        binding.buttonGotoAddRoutine.setOnClickListener{
            //AquiLanzo el intent
        }

         return binding.root
    }

    private fun getData(){
        val modelLiveData: LiveData<RutinaModel> = viewModel.getData()
        modelLiveData.observe(binding.lifecycleOwner!!, object: Observer<RutinaModel>{
            override fun onChanged(t: RutinaModel?) {

                dataList = t!!
                binding.routinePreviewTitle.text = dataList.title
                binding.routineDescriptionPreview.text = dataList.description
                binding.authorNamePreview.text = dataList.user


            }

        })
    }
}

