package com.example.proyectofinaltransporte.network

import kotlinx.serialization.Serializable

@Serializable
class Usuario (
    val id : Long,
    val nombre : String,
    val email : String,
    val password : String
)