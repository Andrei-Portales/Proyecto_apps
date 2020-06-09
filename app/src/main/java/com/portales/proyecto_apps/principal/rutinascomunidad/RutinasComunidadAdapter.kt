package com.portales.proyecto_apps.principal.rutinascomunidad

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.portales.proyecto_apps.databinding.ListItemRoutinesBinding
import com.portales.proyecto_apps.principal.publicacionmodel.RutinaModel

/*
creacion del Adapter para mostrar en laparte de comunidad
 */
class RutinasComunidadAdapter(val clickListener: RutinaModelListener):ListAdapter<RutinaModel,RutinasComunidadAdapter.ViewHolder> (RutinaModelDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(getItem(position)!!, clickListener)
    }

    class ViewHolder private constructor(val binding: ListItemRoutinesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: RutinaModel,
            clickListener: RutinaModelListener
        ) {
            binding.rutinaModel = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater =
                    LayoutInflater.from(parent.context)
                val binding = ListItemRoutinesBinding.inflate(
                    layoutInflater,parent, false
                )
                return ViewHolder(binding)
            }
        }
    }


}
class RutinaModelDiffCallback: DiffUtil.ItemCallback<RutinaModel>(){
    override fun areItemsTheSame(oldItem: RutinaModel, newItem: RutinaModel): Boolean {
        return oldItem.id ==newItem.id
    }

    override fun areContentsTheSame(oldItem: RutinaModel, newItem: RutinaModel): Boolean {
        return oldItem == newItem
    }

}

class RutinaModelListener(val clickListener:(id: String)-> Unit){
    fun onClick(rutinaModel: RutinaModel) = clickListener(rutinaModel.id)
}