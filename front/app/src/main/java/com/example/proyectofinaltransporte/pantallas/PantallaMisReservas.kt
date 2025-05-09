package com.example.proyectofinaltransporte.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController


@Composable
fun PantallaMisReservas(
    reservas: List<String>,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Mis Reservas", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        reservas.forEach { reserva ->
            Text("- $reserva")
            Spacer(modifier = Modifier.height(8.dp))
        }
        Button( onClick = {
            navController.popBackStack(route = "reserva", inclusive = false)
            }
        ) {
            Text(text = "Hacer otra reserva")
        }
    }
}