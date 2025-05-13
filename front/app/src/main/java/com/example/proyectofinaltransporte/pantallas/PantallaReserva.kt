import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.example.proyectofinaltransporte.network.Reserva
import com.example.proyectofinaltransporte.network.Ruta
import com.example.proyectofinaltransporte.API.ReservaApiService
import com.example.proyectofinaltransporte.network.Vehiculo
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaReserva(
    modifier: Modifier = Modifier,
    onNavigateToConfirmacion: () -> Unit
) {
    val tiposVehiculo = listOf("Uber", "Tren", "Avión")
    var tipoSeleccionado by remember { mutableStateOf(tiposVehiculo[0]) }
    var expanded by remember { mutableStateOf(false) }

    var ciudadOrigen by remember { mutableStateOf("") }
    var ciudadDestino by remember { mutableStateOf("") }
    var fechaSalida by remember { mutableStateOf("") }
    var asiento by remember { mutableStateOf("") }

    var error by remember { mutableStateOf<String?>(null) }

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Realizar Reserva", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Dropdown para tipo de vehículo
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                readOnly = true,
                value = tipoSeleccionado,
                onValueChange = {},
                label = { Text("Tipo de Vehículo") },
                trailingIcon = {
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
                },
                modifier = Modifier
                    .menuAnchor()
                    .width(300.dp)
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
            label = { Text("Fecha de Salida (dd/MM/yyyy)") },
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
            scope.launch {
                try {
                    val fecha = fechaSalida
                    val ruta = Ruta(0, ciudadOrigen, ciudadDestino)
                    val asientoParseado = asiento.toInt()
                    val vehiculo = Vehiculo(0, tipoSeleccionado, ruta)
                    val reserva = Reserva(0, fecha,asientoParseado,ruta, vehiculo)

                    ReservaApiService.retrofitService.crearReserva(reserva)

                    onNavigateToConfirmacion()
                } catch (e: Exception) {
                    error = "Error al crear reserva: ${e.localizedMessage}"
                }
            }
        }) {
            Text("Confirmar Reserva")
        }

        error?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}
