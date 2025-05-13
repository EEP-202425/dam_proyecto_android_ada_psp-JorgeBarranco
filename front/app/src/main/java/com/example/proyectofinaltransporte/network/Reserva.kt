package com.example.proyectofinaltransporte.network

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate



@Serializable
class Reserva (
    val id: Long? = null,
    val fechaHora: String,
    val asiento: Int,
    val ruta: Ruta,
    val vehiculo: Vehiculo,
)