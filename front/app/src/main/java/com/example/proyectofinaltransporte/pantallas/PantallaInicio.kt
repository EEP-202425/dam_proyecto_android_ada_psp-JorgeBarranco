package com.example.proyectofinaltransporte.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PantallaLoging(
    modifier: Modifier,
    botonLog: () -> Unit
) {
    var nombre by  remember { mutableStateOf("") }
    var email by  remember { mutableStateOf(" ") }
    var password by  remember { mutableStateOf(" ") }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "INICIE SESIÓN")

        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = {Text("Nombre: ") }
        )
    }
}