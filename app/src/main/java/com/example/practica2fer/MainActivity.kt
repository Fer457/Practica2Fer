package com.example.practica2fer

import androidx.appcompat.app.AppCompatActivity
import com.example.practica2fer.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // funcion del boton, si algun campo esta vacio saca el toast y hace return
        binding.btnCalc.setOnClickListener {
            if (binding.edPeso.text.isNullOrEmpty() || binding.edAltura.text.isNullOrEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.txtToast),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // si no recoge las variables de los ed y hace el calculo
            val peso = binding.edPeso.text.toString().toDouble()
            val altura = binding.edAltura.text.toString().toDouble() / 100
            val result = peso / (altura * altura)

            // si el cb hombre esta checkeado...
            val resultText = if (binding.rb1.isChecked) {
                when (result) {
                    in 0.0..18.5 -> getString(R.string.pesoinf)
                    in 18.5..24.9 -> getString(R.string.pesonor)
                    in 24.9..29.9 -> getString(R.string.sobrepeso)
                    else -> getString(R.string.obesidad)
                }
                // si es el cb de mujer...
            } else {
                when (result) {
                    in 0.0..18.5 -> getString(R.string.pesoinf)
                    in 18.5..23.9 -> getString(R.string.pesonor)
                    in 24.0..28.9 -> getString(R.string.sobrepeso)
                    else -> getString(R.string.obesidad)
                }
            }
            // pone los resultados en los tv
            binding.tvResultado.text = String.format("%.2f", result)
            binding.tvResText.text = resultText
        }
    }
}