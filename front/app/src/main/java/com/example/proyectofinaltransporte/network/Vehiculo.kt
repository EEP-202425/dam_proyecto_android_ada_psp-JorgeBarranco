package com.example.proyectofinaltransporte.network

import kotlinx.serialization.Serializable

@Serializable
class Vehiculo (
    val id : Long,
    val matricula : String,
    val tipo : String,
    val capacidad : Int
)