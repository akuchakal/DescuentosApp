package com.example.descuentosapp.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcularViewModel2: ViewModel() {


    /*private val _precio = mutableStateOf("")
    val precio: State<String> = _precio*/

    var precio by mutableStateOf("")
        private set
    var descuento by mutableStateOf("")
        private set
    var precioDescuento by mutableStateOf(0.0)
        private set
    var totalDescuento by mutableStateOf(0.0)
        private set
    var showAlert by mutableStateOf(false)
        private set

    fun onValuePrecio(value: String) {
        precio = value
    }

    //Funciones de setteo para cuandos on pocos campos!
    fun onValueDescuento(value: String) {
        descuento = value
    }

    fun onValueShowAlert(value: Boolean) {
        showAlert = value
    }

    fun setOnValue(value: String, fieldName: String) {
        when(fieldName) {
            "precio" -> precio = value
            "descuento" -> descuento = value
        }
    }
}