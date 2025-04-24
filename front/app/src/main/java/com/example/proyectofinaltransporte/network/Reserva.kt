package com.example.proyectofinaltransporte.network

import java.time.LocalDateTime

class Reserva (
    val id : Long,
    val fechaHora : LocalDateTime,
    val asiento : Int,
    val ruta : Ruta,
    val usuario : Usuario
)