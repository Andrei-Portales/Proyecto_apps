package com.portales.proyecto_apps.principal.notificaciones
/*
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.work.Data
import androidx.work.WorkManager
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.databinding.NotificacionesFragmentBinding
import com.portales.proyecto_apps.databinding.StartRutinaFragmentBinding
import com.portales.proyecto_apps.principal.MainActivity
import java.text.SimpleDateFormat
import java.util.*
import com.portales.proyecto_apps.principal.notificaciones.WorkManagerN

class NotificacionesFragment : Fragment() {

    companion object {
        fun newInstance() = NotificacionesFragment()
    }

    private lateinit var viewModel: NotificacionesViewModel
    private lateinit var binding: NotificacionesFragmentBinding

    var actual: Calendar = Calendar.getInstance()
    var calendar: Calendar = Calendar.getInstance()

    var minutos: Int =0
    var hora: Int =0
    var dia: Int =0
    var mes: Int =0
    var anio: Int=0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.notificaciones_fragment,
            container,
            false
        )

       binding.FechaButton.setOnClickListener{
           anio = actual.get(Calendar.YEAR)
           mes = actual.get(Calendar.MONTH)
           dia = actual.get(Calendar.DAY_OF_MONTH)

           var datePickerDialog: DatePickerDialog = DatePickerDialog(context as Context, DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->

                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.YEAR, year)

                val format = SimpleDateFormat("dd/MM/yyyy")
                val date = format.format(calendar.getTime())
                binding.FechaText.text = date.toString()


           }, anio, mes, dia)

           datePickerDialog.show()

       }

        binding.HoraButton.setOnClickListener{
            hora = actual.get(Calendar.HOUR_OF_DAY)
            minutos = actual.get(Calendar.MINUTE)

            var timePickerDialog: TimePickerDialog = TimePickerDialog(context as Context, TimePickerDialog.OnTimeSetListener{view, hourOfDay, minute ->
            
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE,minute)

                binding.horaText.text = String.format("%02d:%02d", hourOfDay, minute)



            }, hora,minutos, true)

            timePickerDialog.show()

        }

        binding.EstablecerButton.setOnClickListener{

            var tag = generateKey()
            var alertime = calendar.timeInMillis - System.currentTimeMillis()
            var random: Int = (Math.random() *50 + 1) as Int

            var data: ContactsContract.Contacts.Data = guardarData("Rutina Diaria", "Mantente en forma realizando la rutina diaria", random)
            WorkManagerN.guardarNotificacion(alertime, data, tag)


            Toast.makeText(this.context, "Recordatorio guardado", Toast.LENGTH_SHORT).show()

        }

        binding.EliminarButton.setOnClickListener{

            EliminarNoti("tag1")
        }


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NotificacionesViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun EliminarNoti(tag:String){
        WorkManager.getInstance(context as Context).cancelAllWorkByTag(tag)
        Toast.makeText(this.context, "Recordatorio eliminado", Toast.LENGTH_SHORT).show()

    }

    private fun generateKey(): String{
        return UUID.randomUUID().toString()
    }

    private fun guardarData(titulo: String, detalle:String, idNoti: Int): Data {

        return Data.Builder()
            .putString("titulo", titulo)
            .putString("detalle", detalle)
            .putInt("idNoti", idNoti).build()

    }


}*/