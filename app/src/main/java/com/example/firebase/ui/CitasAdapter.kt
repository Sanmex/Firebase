package com.example.firebase.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.R
import com.example.firebase.databinding.CitaRowBinding
import com.example.firebase.model.Cita


class CitasAdapter : RecyclerView.Adapter<CitasAdapter.Myvh>(){
        private var citaList= emptyList<Cita>()



        class Myvh(itemi: View):RecyclerView.ViewHolder(itemi) {
            var binding =CitaRowBinding.bind(itemi)
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Myvh {
            return Myvh(
                LayoutInflater.from(viewGroup.context).inflate(R.layout.cita_row,viewGroup,false)
            )
        }

        override fun getItemCount()=citaList.size

        override fun onBindViewHolder(holder: Myvh, position: Int) {

            val itemcita=citaList[position]

            holder.binding.contacto.text=itemcita.contactoId.toString()
            var uno=itemcita.fechahora
            holder.binding.fecha.text=uno.toString()

            holder.binding.estado.text=itemcita.estado

            holder.binding.mapa.setOnClickListener {
                holder.binding.mapa.findNavController().navigate(R.id.action_listaCitas_to_maps)
            }

            holder.binding.layoutcita.setOnClickListener {
                holder.binding.layoutcita.findNavController().navigate(R.id.action_listaCitas_to_citasPick)
            }


        }

        fun setData(cita:List<Cita>){
            this.citaList=cita
            notifyDataSetChanged()
        }



    }
