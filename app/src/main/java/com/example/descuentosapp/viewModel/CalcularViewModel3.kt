package com.example.descuentosapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.descuentosapp.model.CalcularState

class CalcularViewModel3 : ViewModel() {
    var state by mutableStateOf(CalcularState())
        private set

    fun setOnValue(value: String, text: String) {
        when (text) {
            "precio" -> state = state.copy(precio = value)
            "descuento" -> state = state.copy(descuento = value)
        }
    }

    fun onValueShowAlert(value: Boolean) {
        state = state.copy(showAlert = value)
    }

    fun calcular() {
        if (state.precio != "" && state.descuento != "") {
            val pDescuento = calcularPrecio(state.precio.toDouble(), state.descuento.toDouble())
            val tDescuento = calcularDescuento(state.precio.toDouble(), state.descuento.toDouble())
            state = state.copy(precioDescuento = pDescuento, totalDescuento = tDescuento)
        } else {
            state = state.copy(showAlert = true)
        }
    }


    private fun calcularPrecio(precio: Double, descuento: Double): Double {
        val res = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(res * 100) / 100.0
    }

    private fun calcularDescuento(precio: Double, descuento: Double): Double {
        val res = precio * (1 - descuento / 100)
        return kotlin.math.round(res * 100) / 100.0
    }

    fun limpiar() {
        state = state.copy(
            precio = "",
            descuento = "",
            precioDescuento = 0.0,
            totalDescuento = 0.0
        )
    }
}