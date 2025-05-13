package com.example.proyectofinaltransporte.network

import kotlinx.serialization.Serializable

@Serializable
data class Vehiculo (
    val id : Long,
    val tipo : String,
    val ruta: Ruta,
)