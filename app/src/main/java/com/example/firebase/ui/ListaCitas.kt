package com.example.firebase.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebase.databinding.FragmentListaCitasBinding

class ListaCitas : Fragment() {

    private var _binding: FragmentListaCitasBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel

    private lateinit var menuInflater: MenuInflater
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListaCitasBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = CitasAdapter()
        val recyclerView = binding.recyclerApp
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //viewmodel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.listAppoint().observe(viewLifecycleOwner, Observer { cita ->
            adapter.setData(cita)


        })



        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}

