package com.example.proyectofinaltransporte.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaReservaPreview() {
    PantallaReserva(onReservaClick = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaReserva(
    modifier: Modifier = Modifier,
    onReservaClick: (String) -> Unit
) {
    val tiposVehiculo = listOf("Uber", "Tren", "Avión")
    var tipoSeleccionado by remember { mutableStateOf(tiposVehiculo[0]) }
    var expanded by remember { mutableStateOf(false) }

    var ciudadOrigen by remember { mutableStateOf("") }
    var ciudadDestino by remember { mutableStateOf("") }
    var fechaSalida by remember { mutableStateOf("") }
    var asiento by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Realizar Reserva")

        Spacer(modifier = Modifier.height(16.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                readOnly = true,
                value = tipoSeleccionado,
                onValueChange = {},
                label = { Text("Tipo de Vehículo") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor().width(300.dp)
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                tiposVehiculo.forEach { tipo ->
                    DropdownMenuItem(
                        text = { Text(tipo) },
                        onClick = {
                            tipoSeleccionado = tipo
                            expanded = false
                        }
                    )
                }
            }
        }

        OutlinedTextField(
            value = ciudadOrigen,
            onValueChange = { ciudadOrigen = it },
            label = { Text("Ciudad de Origen") },
            modifier = Modifier
                .padding(top = 8.dp)
                .width(300.dp)
        )

        OutlinedTextField(
            value = ciudadDestino,
            onValueChange = { ciudadDestino = it },
            label = { Text("Ciudad de Destino") },
            modifier = Modifier
                .padding(top = 8.dp)
                .width(300.dp)
        )

        OutlinedTextField(
            value = fechaSalida,
            onValueChange = { fechaSalida = it },
            label = { Text("Fecha de Salida") },
            modifier = Modifier
                .padding(top = 8.dp)
                .width(300.dp)
        )

        OutlinedTextField(
            value = asiento,
            onValueChange = { asiento = it },
            label = { Text("Asiento") },
            modifier = Modifier
                .padding(top = 8.dp)
                .width(300.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val resumen =
                "Reserva: $tipoSeleccionado - $ciudadOrigen a $ciudadDestino el $fechaSalida (Asiento $asiento)"
            onReservaClick(resumen)
        }) {
            Text("Confirmar Reserva")
        }
    }
}

