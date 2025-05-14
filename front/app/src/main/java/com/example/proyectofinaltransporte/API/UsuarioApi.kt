package com.example.proyectofinaltransporte.API

import com.example.proyectofinaltransporte.network.Usuario
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsuarioApi {
    @GET("usuarios")
    fun getUsuarios(): Usuario

    @POST("usuarios")
    suspend fun crearUsuario(@Body usuario: Usuario): Usuario
}

object UsuarioApiService {
    private const val BASE_URL = "http://10.0.2.2:8080/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: UsuarioApi by lazy {
        retrofit.create(UsuarioApi::class.java)
    }
}
