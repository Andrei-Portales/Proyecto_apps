package com.portales.proyecto_apps.principal.publicar.addroutine

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentAddRoutineBinding
import com.portales.proyecto_apps.principal.publicacionmodel.EjercicioModel
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 * Use the [addRoutineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class addRoutineFragment : Fragment() {
    private lateinit var viewModel: AddRoutineViewModel
    private lateinit var viewModelFactory: AddRoutineViewModelFactory
    private lateinit var binding: FragmentAddRoutineBinding
    private var ejerciciosId = ArrayList<EjercicioModel>()
    private lateinit var adapter: AddRoutineRecyclerAdapter

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
        adapter = AddRoutineRecyclerAdapter(context as Context, ejerciciosId)
        binding.RecyclerEjerciciosAdd.setLayoutManager(LinearLayoutManager(context))
        binding.RecyclerEjerciciosAdd.adapter = adapter
        binding.buttonPublishRoutine.setOnClickListener{
            agregarRutina()
        }

        binding.btnAgregarEjercicio.setOnClickListener {
            addEjercicio()
        }

        addEjercicio()

        return binding.root
    }

    private fun addEjercicio(){
        ejerciciosId.add(EjercicioModel())
        adapter.notifyDataSetChanged()
    }


    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return Random(System.nanoTime()).nextInt(start, end + 1)
    }

    fun main() {
        val start = 5
        val end = 9

        for (i in 1..5) println(rand(start, end))
    }


    private fun agregarRutina(){
        try {
            context?.let { viewModel.agregarRutina(
                RutinaModel(
                    title = binding.routineNameField.text.toString(),
                    description = binding.newRoutineDescriptionField.text.toString(),
                    time = binding.routineDurationField.text.toString().toFloat(),
                    exercises = ejerciciosId
                ), it, view?.findNavController())}

        }catch (e:Exception){
            Toast.makeText(context, "Tienes campos vacios o invalidos",Toast.LENGTH_SHORT).show()
        }


    }

    private fun navigate(){
        val action = addRoutineFragmentDirections.actionAddRoutineFragmentToPublicarRutinaFragment()
        view?.findNavController()?.navigate(action)
    }
}