package com.example.firebase.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebase.R

import com.example.firebase.databinding.FragmentListaContactosBinding


class ListaContactos : Fragment() {

    private var _binding: FragmentListaContactosBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModeli: MainViewModel
    private val adapter:ContactoAdapter by lazy {ContactoAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaContactosBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModeli = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModeli.getContacList().observe(viewLifecycleOwner, Observer {
            adapter.setData(it)


        })
        setUpRecycler()
        buscar(binding.searchbar)
        // setHasOptionsMenu(true)

        /* binding.modelo = mainViewModel
        mainViewModel.contaList.observe(viewLifecycleOwner, Observer {
            binding.mirecyclerView.adapter = ContactoAdapter()
        })*/


        binding.btnflo.setOnClickListener {
            findNavController().navigate(R.id.action_listaContactos_to_registro)
        }
    }

    private fun setUpRecycler() {
        val recyclerView = binding.mirecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"
        mainViewModeli.searchDatabase(searchQuery).observe(this, Observer {list ->
            list.let{
                adapter.setData(it)
            }
        })

    }
    private fun buscar(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (query != null) {
                    searchDatabase(query)
                }
                return true

            }

            override fun onQueryTextChange(newText: String): Boolean {

                return true
            }
        })

    }
}


