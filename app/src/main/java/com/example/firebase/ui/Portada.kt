package com.example.firebase.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firebase.R
import com.example.firebase.databinding.FragmentPortadaBinding

class Portada : Fragment() {
    private var _binding:FragmentPortadaBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentPortadaBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btncon.setOnClickListener {
            findNavController().navigate(R.id.action_portada_to_listaContactos)
        }

        binding.btncitas.setOnClickListener{
            findNavController().navigate(R.id.action_portada_to_listaCitas)
        }

    }




}