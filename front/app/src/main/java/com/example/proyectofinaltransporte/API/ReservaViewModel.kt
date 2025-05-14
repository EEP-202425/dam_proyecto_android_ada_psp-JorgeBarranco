package com.example.proyectofinaltransporte.API

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinaltransporte.network.Reserva
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ReservaViewModel : ViewModel() {

    private val _reservas = MutableStateFlow<List<Reserva>>(emptyList())
    val reservas: StateFlow<List<Reserva>> = _reservas.asStateFlow()

    fun cargarReservas() {
        viewModelScope.launch {
            try {
                val lista = ReservaApiService.retrofitService.getReservas()
                _reservas.value = lista
            } catch (e: Exception) {
            }
        }
    }
}