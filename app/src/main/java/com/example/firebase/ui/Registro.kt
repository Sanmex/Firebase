package com.example.firebase.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.firebase.R
import com.example.firebase.databinding.FragmentRegistroBinding
import com.example.firebase.model.Contacto
import com.example.firebase.model.Oferta
import com.example.firebase.model.Telefono
import kotlinx.coroutines.launch

class Registro : Fragment() {
    private var _binding:FragmentRegistroBinding?=null
    private val binding get() = _binding!!

    private lateinit var mainViewModel:MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentRegistroBinding.inflate(inflater,container,false)
        val view=binding.root
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnguardar.setOnClickListener {
            insertDataTodb()
        }
    }
    private fun insertDataTodb(){
        //get the text of the edit text
        val nombre=binding.regNom.text.toString()
        val direccion=binding.regDirecc.text.toString()
        val email=binding.regmail.text.toString()
        if(inputCheck(nombre, direccion, email)){
            //si true se crea contacto
            val contacto= Contacto(0L,nombre,direccion,email)

            saveContact(contacto)
            Toast.makeText(context,"Id $id se ha insertado", Toast.LENGTH_SHORT).show()



            Toast.makeText(requireContext(),"Ya se guardo",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_registro_to_listaContactos)
        }else{
            Toast.makeText(requireContext(),"Llene todos los campos",Toast.LENGTH_SHORT).show()
        }
    }


    private fun inputCheck(nombre:String,direccion:String,email:String):Boolean{
        return !(TextUtils.isEmpty(nombre) && TextUtils.isEmpty(direccion) && TextUtils.isEmpty(email))
    }
    //por que solo fùnciono con lifecycle

    private fun saveContact(contacto: Contacto) = lifecycleScope.launch {

        val id = mainViewModel.saveContact(contacto)

        val tel1=binding.regTel.text.toString()
        val tel2=binding.regTelii.text.toString()
        val telefonos=Telefono(0L,tel2,id)
        val telefonos1= Telefono(0L,tel1,id)
        mainViewModel.saveTelList(telefonos)
        mainViewModel.saveTelList(telefonos1)

        val puesto=binding.regpues.text.toString()
        val sueldo=binding.regsal.text.toString()
        val horario="7am a 9am"
        val oferta= Oferta(0L,puesto,sueldo,horario,id)
        mainViewModel.saveOfer(oferta)




    }


}





