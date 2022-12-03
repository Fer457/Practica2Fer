package com.example.practica2fer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica2fer.databinding.PesoBinding

class RecyclerAdapter(private var pesos: List<Peso>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holderMy: MyViewHolder, position: Int) {
        val item = pesos[position]
        holderMy.bind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(
            PesoBinding.inflate(
                layoutInflater,
                parent,
                false
            ).root
        )
    }

    override fun getItemCount(): Int {
        return pesos.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = PesoBinding.bind(view)

        fun bind(peso: Peso) {
            binding.tvImc.text = peso.imc.toString()
            binding.tvGenero.text = peso.genero
            binding.tvFecha.text = peso.fecha
            binding.tvEstado.text = peso.estado

        }
    }
}