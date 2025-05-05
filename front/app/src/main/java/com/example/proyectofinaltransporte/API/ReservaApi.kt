package com.example.proyectofinaltransporte.API

import com.example.proyectofinaltransporte.API.UsuarioApi.UsuarioApi
import com.example.proyectofinaltransporte.network.Reserva
import com.example.proyectofinaltransporte.network.Usuario
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

private const val BASE_URL =
    "http://localhost:8080/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ReservaApi {
    @GET("reservas")
    fun getReservas(): Reserva

    @POST("reservas")
    fun crearReserva(@Body reserva: Reserva): Reserva

    @PUT("reservas/{id}")
    fun actualizarReserva(@Path("id") id: Long, @Body reserva: Reserva): Reserva

    @DELETE("reservas/{id}")
    fun eliminarReserva(@Path("id") id: Long): Void

    object ReservaApi {
        val retofitService: ReservaApi by lazy {
            retrofit.create(ReservaApi::class.java)
        }
    }
}