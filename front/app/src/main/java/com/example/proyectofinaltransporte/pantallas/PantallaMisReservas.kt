package com.example.proyectofinaltransporte.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PantallaMisReservasPreview() {
    PantallaMisReservas(
        reservas = listOf(
            "Uber - Madrid a Barcelona - 12/06/2025 - Asiento A1",
            "Tren - Sevilla a Valencia - 15/06/2025 - Asiento B3"
        )
    )
}

@Composable
fun PantallaMisReservas(reservas: List<String>) {
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
    }
}