package com.example.proyectofinaltransporte.pantallas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proyectofinaltransporte.API.ReservaViewModel
import com.example.proyectofinaltransporte.network.Reserva

@Composable
fun PantallaMisReservas(
    reservaViewModel: ReservaViewModel,
    navController: NavHostController
) {
    val reservas = reservaViewModel.reservas.collectAsState().value

    LaunchedEffect(Unit) {
        reservaViewModel.cargarReservas()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Mis Reservas", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.popBackStack(route = "reserva", inclusive = false)
        }) {
            Text(text = "Hacer otra reserva")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(reservas) { reserva ->
                ReservaItem(reserva)
                Divider()
            }
        }
    }
}

@Composable
fun ReservaItem(reserva: Reserva) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Text("Fecha: ${reserva.fechaHora}")
        Text("Asiento: ${reserva.asiento}")
        Text("Ruta: ${reserva.ruta.ciudadOrigen} → ${reserva.ruta.ciudadDestino}")
        Text("Vehículo: ${reserva.vehiculo.tipo}")
    }
}