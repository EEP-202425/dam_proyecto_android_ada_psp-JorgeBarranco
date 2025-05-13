package com.example.proyectofinaltransporte

import PantallaReserva
import android.os.Bundle
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
import com.example.proyectofinaltransporte.pantallas.PantallaConfirmacion
import com.example.proyectofinaltransporte.pantallas.PantallaLoging
import com.example.proyectofinaltransporte.pantallas.PantallaMisReservas
import com.example.proyectofinaltransporte.ui.theme.ProyectoFinalTransporteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoFinalTransporteTheme {
                val navController = rememberNavController()
                var reservaViewModel: ReservaViewModel = viewModel()

                NavHost(navController, startDestination = "login") {
                    composable("login") {
                        PantallaLoging(
                            modifier = Modifier.fillMaxSize(),
                            botonLog = {
                                navController.navigate("reserva")
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