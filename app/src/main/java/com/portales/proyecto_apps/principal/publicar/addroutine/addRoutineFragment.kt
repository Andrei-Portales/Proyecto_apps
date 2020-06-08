package com.portales.proyecto_apps.principal.publicar.addroutine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentAddRoutineBinding
import com.portales.proyecto_apps.principal.publicacionmodel.EjercicioModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

/**
 * A simple [Fragment] subclass.
 * Use the [addRoutineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class addRoutineFragment : Fragment() {
    private lateinit var viewModel: AddRoutineViewModel
    private lateinit var viewModelFactory: AddRoutineViewModelFactory
    private lateinit var binding: FragmentAddRoutineBinding

    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentAddRoutineBinding>(
            inflater,
            R.layout.fragment_add_routine,container,false
        )
        viewModelFactory = AddRoutineViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(AddRoutineViewModel::class.java)

        binding.lifecycleOwner = this

        binding.buttonPublishRoutine.setOnClickListener{
            navigate()

        }



        return binding.root
    }

    private fun verifier():Boolean{

        return (
                binding.inserDescriptionExcercise1.text.isNullOrEmpty()||
                        binding.inserDescriptionExcercise2.text.isNullOrEmpty()||
                        binding.inserDescriptionExcercise3.text.isNullOrEmpty()||
                        binding.insertNameExcercise1.text.isNullOrEmpty()||
                        binding.insertNameExcercise2.text.isNullOrEmpty()||
                        binding.insertNameExcercise3.text.isNullOrEmpty()||
                        binding.insertYoutubeLink1.text.isNullOrEmpty()||
                        binding.insertYoutubeLink2.text.isNullOrEmpty()||
                        binding.insertYoutubeLink3.text.isNullOrEmpty()||
                        binding.routineNameField.text.isNullOrEmpty()||
                        binding.newRoutineDescriptionField.text.isNullOrEmpty()||
                        binding.routineDurationField.text.isNullOrEmpty()

                )
    }
    private fun agregarRutina(){
        val ejercicios: ArrayList<EjercicioModel> = arrayListOf<EjercicioModel>(
            EjercicioModel(title = binding.insertNameExcercise1.text.toString(),description = binding.inserDescriptionExcercise1.text.toString(),video =  binding.insertYoutubeLink1.text.toString()),
            EjercicioModel(title = binding.insertNameExcercise2.text.toString(),description = binding.inserDescriptionExcercise2.text.toString(),video =  binding.insertYoutubeLink2.text.toString()),
            EjercicioModel(title = binding.insertNameExcercise3.text.toString(),description = binding.inserDescriptionExcercise3.text.toString(),video =  binding.insertYoutubeLink3.text.toString()))

        context?.let { viewModel.agregarRutina(
            RutinaModel(
                title = binding.routineNameField.text.toString(),
                description = binding.newRoutineDescriptionField.text.toString(),
                time = binding.routineDurationField.text.toString().toFloat(),
                exercises = ejercicios

            ), it) }


    }

    private fun navigate(){
        if (!verifier()) {
            val action = addRoutineFragmentDirections.actionAddRoutineFragmentToPublicarRutinaFragment()
            view?.findNavController()?.navigate(action)
        }
        else{
            Toast.makeText(context,"Porfavor llene los campos vacios", Toast.LENGTH_LONG).show()
        }
    }
}