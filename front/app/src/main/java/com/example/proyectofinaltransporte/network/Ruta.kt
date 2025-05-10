package com.example.proyectofinaltransporte.network

import kotlinx.serialization.Serializable

@Serializable
class Ruta (
    val id : Long,
    val ciudadOrigen : String,
    val ciudadDestino : String,
    val km : Int
)
