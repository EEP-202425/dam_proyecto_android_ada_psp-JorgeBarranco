package com.example.proyectofinaltransporte.pantallas

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.proyectofinaltransporte.network.Usuario

@Composable
fun PantallaLoging(
    modifier: Modifier,
    botonLog: (Usuario) -> Unit
) {
    var nombreUsuario by  remember { mutableStateOf("") }
    var emailUsuario by  remember { mutableStateOf("") }
    var passwordUsuario by  remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "INICIE SESIÓN")

        OutlinedTextField(
            value = nombreUsuario,
            onValueChange = { nombreUsuario = it },
            label = { Text("Nombre: ") },
            modifier = Modifier.width(300.dp)
        )

        OutlinedTextField(
            value = emailUsuario,
            onValueChange = { emailUsuario = it },
            label = { Text("Email: ") },
            modifier = Modifier.width(300.dp)
        )

        OutlinedTextField(
            value = passwordUsuario,
            onValueChange = { passwordUsuario = it },
            label = { Text("Contraseña: ") },
            modifier = Modifier.width(300.dp)
        )

        Spacer(Modifier.height(10.dp))

        Button(
            onClick = {
                val usuario = Usuario(
                    nombre = nombreUsuario,
                    email = emailUsuario,
                    password = passwordUsuario
                )
                botonLog(usuario)
            },
            modifier = Modifier.width(150.dp)
        ) {
            Text("Guardar")
        }
    }
    }