package com.example.proyectofinaltransporte.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaLoging(
    modifier: Modifier,
    botonLog: () -> Unit
) {
    var nombre by  remember { mutableStateOf(" ") }
    var email by  remember { mutableStateOf(" ") }
    var password by  remember { mutableStateOf(" ") }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "INICIE SESIÓN")

        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = {Text("Nombre: ") },
            modifier = Modifier.width(300.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("Email: ") },
            modifier = Modifier.width(300.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Contraseña: ") },
            modifier = Modifier.width(300.dp)
        )

        Spacer(Modifier.height(10.dp))

        Button(onClick =
        botonLog, modifier = Modifier.width(150.dp)) {
            Text("Guardar")
        }

    }
}