package com.example.firebase.ui


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.firebase.R
import com.example.firebase.databinding.FragmentCitasPickBinding
import com.example.firebase.model.Cita
import java.text.SimpleDateFormat
import java.util.*


class CitasPick : Fragment(),DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    var foremateDate = SimpleDateFormat("dd mm yyyy", Locale.UK)
    private var _binding: FragmentCitasPickBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel:MainViewModel
    private val args by navArgs<CitasPickArgs>()

    val idAppoint=arguments?.getLong("id")
    var day=0
    var month=0
    var year=0
    var hour=0
    var minut=0

    var saveDay=0
    var saveMonth=0
    var saveYear=0
    var saveMinute=0
    var saveHour=0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCitasPickBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showCita()
        pickDate()
        binding.btnguardarcita.setOnClickListener {
            val conid=args.currentCont.id
            val a=saveYear
            val me=saveMonth
            val di=saveDay
            val ho=saveHour
            val min=saveMinute
            val cal =Calendar.getInstance ()
            cal.set(a,me,di,ho,min)
            val cita= Cita(0L,cal.time,"yaaa",conid)


            mainViewModel.saveCitaList(cita)

            Toast.makeText(requireContext(),"ya me guarde", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_citasPick_to_listaCitas)


        }
        //añadir texto clickable a las cardview para enlazar contacto y cita.


    }



    private fun pickDate() {
        binding.desplegar.setOnClickListener {
            getDateTimeCalendar()
            DatePickerDialog(requireContext(), this, year, month, day).show()

        }
    }
    private fun getDateTimeCalendar(){
        val calendar= Calendar.getInstance()
        day=calendar.get(Calendar.DAY_OF_MONTH)
        month=calendar.get(Calendar.MONTH)
        year=calendar.get(Calendar.YEAR)
        hour=calendar.get(Calendar.HOUR)
        minut=calendar.get(Calendar.MINUTE)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        saveDay = dayOfMonth
        saveMonth = month+1
        saveYear = year

        getDateTimeCalendar()
        TimePickerDialog(requireContext(), this, hour, minut, true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        saveHour = hourOfDay
        saveMinute = minute

        binding.tvcitas.text = "$saveDay-$saveMonth-$saveYear\n Hour: $saveHour-Minute:$saveMinute"





    }
    private fun showCita() {
     mainViewModel.getContactCita(args.currentCont.id).observe(viewLifecycleOwner,androidx.lifecycle.Observer{ citaslist ->
         binding.tvcitas.setText(citaslist.citas[0].fechahora.toString())

     })

    }

}















/* val c=Calendar.getInstance()
 val year=c.get(Calendar.YEAR)
 val month=c.get(Calendar.MONTH)
 val day=c.get(Calendar.DAY_OF_MONTH)

 binding.btncitas.setOnClickListener {
     val dtp = DatePickerDialog(requireContext(),android.R.style.Theme_Holo_Light_Dialog_MinWidth,DatePickerDialog.OnDateSetListener { view, myear, mmonth, mday ->
           binding.tvcitas.setText(""+myear+"/"+mmonth+"/"+mday)
     },year,month,day)
     dtp.show()
 }


 //spinner.onitenselectedlistener = object:AdapterView.OnitemSelectedListener{
 //clase anonima,implementar miembros
 //onitemselected adapter,view,position,id
  binding.btncitas.setOnClickListener (View.OnClickListener {
     val getDate = Calendar.getInstance()
     val datePicker = DatePickerDialog(
         requireContext(),
         android.R.style.Theme_Holo_Light_Dialog_MinWidth,
             { datePicker, i, i2, i3 ->
                 val selectDate = Calendar.getInstance()
                 selectDate.set(Calendar.YEAR, i)
                 selectDate.set(Calendar.MONTH, i2)
                 selectDate.set(Calendar.DAY_OF_MONTH, i3)
                 val date = foremateDate.format(selectDate.time)
                 Toast.makeText(requireContext(), "Date:$date", Toast.LENGTH_SHORT).show()
                 binding.tvcita.text = date
             },
             getDate.get(Calendar.YEAR),
             getDate.get(Calendar.MONTH),
             getDate.get(Calendar.DAY_OF_MONTH))
                 datePicker . show ()

     })

 }*/







