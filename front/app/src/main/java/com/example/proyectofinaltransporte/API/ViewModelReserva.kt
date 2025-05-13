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
    data class Error(val message: String) : ReservaUiState
    object Loading : ReservaUiState
    object Initial : ReservaUiState
}

class ReservaViewModel : ViewModel() {

    var reservaUiState: ReservaUiState by mutableStateOf(ReservaUiState.Initial)
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
                ReservaUiState.Error("Error de conexión: ${e.message}")
            } catch (e: HttpException) {
                ReservaUiState.Error("Error del servidor: ${e.message}")
            }
        }
    }

    fun crearReserva(reserva: Reserva) {
        viewModelScope.launch {
            reservaUiState = ReservaUiState.Loading
            try {
                val nuevaReserva = ReservaApiService.retrofitService.crearReserva(reserva)
                reservaUiState = ReservaUiState.Success("Reserva creada con éxito")
            } catch (e: IOException) {
                reservaUiState = ReservaUiState.Error("Error de conexión: ${e.message}")
            } catch (e: HttpException) {
                reservaUiState = ReservaUiState.Error("Error del servidor: ${e.message}")
            } catch (e: Exception) {
                reservaUiState = ReservaUiState.Error("Error desconocido: ${e.message}")
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
                reservaUiState = ReservaUiState.Error("Error al actualizar la reserva: ${e.message}")
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
                reservaUiState = ReservaUiState.Error("Error al eliminar la reserva: ${e.message}")
            }
        }
    }

}