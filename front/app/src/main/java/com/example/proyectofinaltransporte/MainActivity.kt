package com.example.proyectofinaltransporte

import PantallaReserva
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectofinaltransporte.API.ReservaViewModel
import com.example.proyectofinaltransporte.API.UsuarioApi
import com.example.proyectofinaltransporte.API.UsuarioApiService
import com.example.proyectofinaltransporte.pantallas.PantallaConfirmacion
import com.example.proyectofinaltransporte.pantallas.PantallaLoging
import com.example.proyectofinaltransporte.pantallas.PantallaMisReservas
import com.example.proyectofinaltransporte.ui.theme.ProyectoFinalTransporteTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoFinalTransporteTheme {
                val navController = rememberNavController()
                val reservaViewModel: ReservaViewModel = viewModel()
                val userApi = UsuarioApiService.retrofitService

                NavHost(navController, startDestination = "login") {
                    composable("login") {
                        PantallaLoging(
                            modifier = Modifier.fillMaxSize(),
                            botonLog = {usuario ->
                                CoroutineScope(Dispatchers.IO).launch {
                                    try {
                                        val usuarioCreado = userApi.crearUsuario(usuario)
                                        withContext(Dispatchers.Main) {
                                            navController.navigate("reserva")
                                        }
                                    } catch (e: Exception) {
                                        Log.e("API", "Error creando usuario: ${e.message}")
                                    }
                                }
                            }
                        )
                    }

                    composable("reserva") {
                        PantallaReserva(
                            onNavigateToConfirmacion = {
                                navController.navigate("confirmacion")
                            }
                        )
                    }

                    composable("confirmacion") {
                        PantallaConfirmacion(
                            onVerReservasClick = {
                                navController.navigate("mis_reservas")
                            }
                        )
                    }

                    composable("mis_reservas") {
                        PantallaMisReservas(
                            reservaViewModel = reservaViewModel,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}