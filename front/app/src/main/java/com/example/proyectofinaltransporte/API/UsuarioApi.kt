package com.example.proyectofinaltransporte.API

import com.example.proyectofinaltransporte.network.Usuario
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL =
    "http://localhost:8080/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface UsuarioApi {
    @GET("usuarios")
    fun getUsuarios(): Usuario

    @POST("usuarios")
    fun crearUsuario(@Body usuario: Usuario): Usuario

    object UsuarioApi {
            val retofitService: UsuarioApi by lazy {
                retrofit.create(UsuarioApi::class.java)
            }
        }
}