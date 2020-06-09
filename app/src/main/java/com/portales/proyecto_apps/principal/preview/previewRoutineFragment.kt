package com.portales.proyecto_apps.principal.preview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.FragmentPreviewRoutineBinding

/**
 * A simple [Fragment] subclass.
 * Use the [previewRoutineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class previewRoutineFragment : Fragment() {
    private lateinit var viewModel: PreviewRoutineViewModel
    private lateinit var viewModelFactory: PreviewRoutineViewModelFactory
    private lateinit var binding: FragmentPreviewRoutineBinding

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

       // viewModelFactory =

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}

