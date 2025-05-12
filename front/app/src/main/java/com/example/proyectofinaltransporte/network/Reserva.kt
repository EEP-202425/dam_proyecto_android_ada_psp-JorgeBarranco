package com.example.proyectofinaltransporte.network

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate



@Serializable
class Reserva (
    val id : Long,
    @Contextual val fechaHora : LocalDate,
    val asiento : String,
    val ruta : Ruta,
)