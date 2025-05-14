package com.example.proyectofinaltransporte.network

import kotlinx.serialization.Serializable

@Serializable
data class Usuario (
    val id: Long? = null,
    val nombre : String,
    val email : String,
    val password : String
)