package com.example.proyectofinaltransporte.API

import com.example.proyectofinaltransporte.network.Reserva
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val BASE_URL = "http://10.0.2.2:8080/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ReservaApi {

    @GET("reservas")
    suspend fun getReservas(): List<Reserva>

    @POST("reservas")
    suspend fun crearReserva(@Body reserva: Reserva): Reserva

    @PUT("reservas/{id}")
    suspend fun actualizarReserva(@Path("id") id: Long, @Body reserva: Reserva): Reserva

    @DELETE("reservas/{id}")
    suspend fun eliminarReserva(@Path("id") id: Long): Void
}

object ReservaApiService {
    val retrofitService: ReservaApi by lazy {
        retrofit.create(ReservaApi::class.java)
    }
}
