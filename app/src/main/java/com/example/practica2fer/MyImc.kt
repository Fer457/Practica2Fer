package com.example.practica2fer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.practica2fer.databinding.FragmentMyImcBinding
import androidx.navigation.fragment.findNavController
import java.util.*

class MyImc : Fragment() {
    private lateinit var binding: FragmentMyImcBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyImcBinding.inflate(inflater, container, false)

        // funcion del boton, si algun campo esta vacio saca el toast y hace return
        binding.btnCalc.setOnClickListener {
            if (binding.edPeso.text.isNullOrEmpty() || binding.edAltura.text.isNullOrEmpty()) {
                Toast.makeText(
                    requireActivity(),
                    getString(R.string.txtToast),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // si no recoge las variables de los ed y hace el calculo
            val peso = binding.edPeso.text.toString().toDouble()
            val altura = binding.edAltura.text.toString().toDouble() / 100
            val result = peso / (altura * altura)
            val genero: String
            val hoy = Calendar.getInstance()
            val fecha = "${hoy.get(Calendar.DAY_OF_MONTH)}-${hoy.get(Calendar.MONTH) + 1}-${hoy.get(Calendar.YEAR)}"

            // si el cb hombre esta checkeado...
            val resultText = if (binding.rb1.isChecked) {
                genero = "Hombre"
                when (result) {
                    in 0.0..18.5 -> getString(R.string.pesoinf)
                    in 18.5..24.9 -> getString(R.string.pesonor)
                    in 24.9..29.9 -> getString(R.string.sobrepeso)
                    else -> getString(R.string.obesidad)
                }
                // si es el cb de mujer...
            } else {
                genero = "Mujer"
                when (result) {
                    in 0.0..18.5 -> getString(R.string.pesoinf)
                    in 18.5..23.9 -> getString(R.string.pesonor)
                    in 24.0..28.9 -> getString(R.string.sobrepeso)
                    else -> getString(R.string.obesidad)
                }
            }

            Historico.pesos.add(Peso(result,genero,fecha,resultText))

            // pone los resultados en los tv
            binding.tvResultado.text = String.format("%.2f", result)
            binding.tvResText.text = resultText
        }

        binding.btnHistorico.setOnClickListener{
            findNavController().navigate(
                MyImcDirections.actionMyImcToRecyclerView()
            )
        }

        return binding.root


    }

}