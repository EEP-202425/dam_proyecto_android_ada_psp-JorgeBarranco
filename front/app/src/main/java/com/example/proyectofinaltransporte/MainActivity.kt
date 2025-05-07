package com.example.proyectofinaltransporte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectofinaltransporte.pantallas.PantallaConfirmacion
import com.example.proyectofinaltransporte.pantallas.PantallaLoging
import com.example.proyectofinaltransporte.pantallas.PantallaMisReservas
import com.example.proyectofinaltransporte.pantallas.PantallaReserva
import com.example.proyectofinaltransporte.ui.theme.ProyectoFinalTransporteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoFinalTransporteTheme {
                val navController = rememberNavController()
                val reservas = remember { mutableStateListOf<String>() }

                var vm: ViewModel

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
                            onReservaClick = { reserva ->
                                reservas.add(reserva)
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
                            reservas,
                            navController
                        )
                    }
                }
            }
        }
    }
}