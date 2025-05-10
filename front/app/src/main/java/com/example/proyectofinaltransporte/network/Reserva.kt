package com.example.proyectofinaltransporte.network

import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

@Serializable
class Reserva (
    val id : Long,
    val fechaHora : LocalDate,
    val asiento : Int,
    val ruta : Ruta,
    val usuario : Usuario
)