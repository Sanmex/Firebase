package com.example.firebase.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.firebase.R
import com.example.firebase.databinding.FragmentEditarContactBinding
import com.example.firebase.model.Contacto
import kotlinx.android.synthetic.main.fragment_editar_contact.*

class EditarContact : Fragment() {
    private var _binding:FragmentEditarContactBinding?=null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel
    private val args by navArgs<EditarContactArgs>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding= FragmentEditarContactBinding.inflate(inflater,container,false)
        val view=binding.root
        //set text
        mainViewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        binding.editnom.setText(args.currentItem.nombre)
        binding.editdirecc.setText(args.currentItem.direccion)
        binding.editmail.setText(args.currentItem.mail)
        gettel()








        binding.btnupdate.setOnClickListener {
            updateItem()
        }
        //add menu

        setHasOptionsMenu(true)
        return view
    }


    private fun updateItem(){
        val nombre=editnom.text.toString()
        val direccion=editdirecc.text.toString()
        val email=editmail.text.toString()

        if(inputCheck(nombre ,direccion,email)){
            //primero se crea el objeto contacto
            val updateContact= Contacto(args.currentItem.id,nombre,direccion,email)
            //desapues se llama a la funcion update

            mainViewModel.updateContact(updateContact)
            Toast.makeText(requireContext(),"Editado con exitos",Toast.LENGTH_SHORT).show()
            //de retro a la lista
            findNavController().navigate(R.id.action_editarContact_to_listaCitas)

        }else{
            Toast.makeText(requireContext(),"Rellene los campos",Toast.LENGTH_SHORT).show()
        }

    }
    private fun inputCheck(nombre:String,direccion:String,email:String):Boolean{
        return !(TextUtils.isEmpty(nombre) && TextUtils.isEmpty(direccion) && TextUtils.isEmpty(email))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_delete,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete){
            deleteContacto()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteContacto(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("yes"){ _,_->
            mainViewModel.borrarContacto(args.currentItem)
            Toast.makeText(requireContext(),"Removido",Toast.LENGTH_SHORT).show()
            //pa la lista otra vez
            findNavController().navigate(R.id.action_editarContact_to_listaContactos)
        }
        builder.setNegativeButton("nop"){ _,_ ->}
        builder.setTitle("Delete ${args.currentItem.nombre}")
        builder.setMessage("Are you sure? You will delete ${args.currentItem.nombre}")
        builder.create().show()

    }


    private fun gettel() {
        mainViewModel.getContTel(args.currentItem.id)
            .observe(viewLifecycleOwner, Observer { telists ->
                // si son mas campos necesarios para la lista se podria hacer variable para el index
                binding.editel.setText(telists.tels[0].numero)
                binding.editelii.setText(telists.tels[1].numero)
            })
    }











}