package com.example.practica2fer

data class Peso(val imc: Double, val genero: String, val fecha: String, val estado: String) {
    var imcValue: Double? = null
    var generoValue: String? = null
    var fechaValue: String? = null
    var estadoValue: String? = null

    init {
        this.imcValue = imc
        this.generoValue = genero
        this.fechaValue = fecha
        this.estadoValue = estado
    }
}
