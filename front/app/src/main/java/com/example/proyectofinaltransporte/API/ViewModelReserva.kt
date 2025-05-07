package com.example.proyectofinaltransporte.API

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinaltransporte.API.ReservaApiService
import com.example.proyectofinaltransporte.network.Reserva
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface ReservaUiState {
    data class Success(val message: String) : ReservaUiState
    object Error : ReservaUiState
    object Loading : ReservaUiState
}

class ReservaViewModel : ViewModel() {

    var reservaUiState: ReservaUiState by mutableStateOf(ReservaUiState.Loading)
        private set

    init {
        getReservas()
    }

    fun getReservas() {
        viewModelScope.launch {
            reservaUiState = ReservaUiState.Loading
            reservaUiState = try {
                val reservas = ReservaApiService.retrofitService.getReservas()
                ReservaUiState.Success("Se cargaron ${reservas.size} reservas")
            } catch (e: IOException) {
                ReservaUiState.Error
            } catch (e: HttpException) {
                ReservaUiState.Error
            }
        }
    }

    fun crearReserva(reserva: Reserva) {
        viewModelScope.launch {
            reservaUiState = ReservaUiState.Loading
            try {
                ReservaApiService.retrofitService.crearReserva(reserva)
                reservaUiState = ReservaUiState.Success("Reserva creada con éxito")
            } catch (e: Exception) {
                reservaUiState = ReservaUiState.Error
            }
        }
    }

    fun actualizarReserva(id: Long, reserva: Reserva) {
        viewModelScope.launch {
            reservaUiState = ReservaUiState.Loading
            try {
                ReservaApiService.retrofitService.actualizarReserva(id, reserva)
                reservaUiState = ReservaUiState.Success("Reserva actualizada con éxito")
            } catch (e: Exception) {
                reservaUiState = ReservaUiState.Error
            }
        }
    }

    fun eliminarReserva(id: Long) {
        viewModelScope.launch {
            reservaUiState = ReservaUiState.Loading
            try {
                ReservaApiService.retrofitService.eliminarReserva(id)
                reservaUiState = ReservaUiState.Success("Reserva eliminada con éxito")
            } catch (e: Exception) {
                reservaUiState = ReservaUiState.Error
            }
        }
    }

}

