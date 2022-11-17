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
            if (binding.edPeso.text.isNullOrEmpty() || binding.edAltura.text.isNullOrEmpty()){
                Toast.makeText(this, "Los campos Peso y Altura no deben estar vacíos para realizar el cálculo.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // si no recoge las variables de los ed y hace el calculo
            val peso = binding.edPeso.text.toString().toDouble()
            val altura = binding.edAltura.text.toString().toDouble()/100
            val result = peso/(altura * altura)

            // si el cb hombre esta checkeado...
            val resultText = if (binding.rb1.isChecked){
                if (result < 18.5) "Peso inferior al normal"
                else if (result in 18.5..24.9) "Normal"
                else if (result in 24.9..29.9) "Sobrepeso"
                else "Obesidad"
            // si es el cb de mujer...
            } else {
                if (result < 18.5) "Peso inferior al normal"
                else if (result in 18.5..23.9) "Normal"
                else if (result in 24.0..28.9) "Sobrepeso"
                else "Obesidad"
            }

            // pone los resultados en los tv
            binding.tvResultado.text = String.format("%.2f", result)
            binding.tvResText.text = resultText

        }
    }
}