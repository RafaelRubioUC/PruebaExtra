package com.example.clima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clima.ui.theme.ClimaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClimaTheme {
                ControladorNavegacion()
            }
        }
    }
}

@Composable
fun FichaClimatica(etiqueta: String, valor: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = etiqueta,
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = valor,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun LineaDivisoria() {
    HorizontalDivider(color = Color.White.copy(alpha = 0.05f), thickness = 0.5.dp)
}

@Composable
fun RenglonSemanal(dia: String, emoji: String, max: String, min: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = dia, color = Color.White, fontSize = 13.sp, modifier = Modifier.width(36.dp))
        Text(
            text = emoji,
            fontSize = 18.sp
        )
        Row {
            Text(text = max, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
            Text(text = " / ", color = Color.White.copy(alpha = 0.3f), fontSize = 13.sp)
            Text(text = min, color = Color.White.copy(alpha = 0.6f), fontSize = 13.sp)
        }
    }
}

@Composable
fun CeldaInformacion(etiqueta: String, valor: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = etiqueta, color = Color.White.copy(alpha = 0.6f), fontSize = 11.sp)
        Text(text = valor, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Composable
fun ElementoHorario(hora: String, emoji: String, temperatura: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = hora, color = Color.White, fontSize = 10.sp)
        Text(
            text = emoji,
            modifier = Modifier.padding(vertical = 2.dp),
            fontSize = 20.sp
        )
        Text(text = temperatura,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TituloSeccion(texto: String) {
    Text(
        text = texto,
        modifier = Modifier.padding(bottom = 6.dp),
        fontSize = 10.sp,
        color = Color.White.copy(alpha = 0.7f),
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun VistaDetallada() {
    val gradienteFondo = Brush.verticalGradient(
        colors = listOf(Color(0xFFA0B5EB), Color(0xFFEA52F8), Color(0xFF0066FF))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradienteFondo)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 45.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "El Salvador",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "25°C", color = Color.White, fontSize = 56.sp, fontWeight = FontWeight.Bold)
                Text(text = "Soleado", color = Color.White.copy(alpha = 0.8f), fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            TituloSeccion("PRONOSTICO POR HORAS")
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ElementoHorario("Ahora", "\u2600", "25°")
                    ElementoHorario("14:00", "\u2600", "26°")
                    ElementoHorario("16:00", "\u26C5", "24°")
                    ElementoHorario("18:00", "\u26C5", "22°")
                    ElementoHorario("20:00", "\uD83C\uDF19", "20°")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.15f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    TituloSeccion("DETALLES")
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        CeldaInformacion("Humedad", "65%")
                        CeldaInformacion("Viento", "12 km/h")
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        CeldaInformacion("Presion", "1012 hPa")
                        CeldaInformacion("UV", "5")
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            TituloSeccion("PRONOSTICO SEMANAL")
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.15f)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)) {
                    RenglonSemanal("Lun", "\u2600", "28°", "22°")
                    LineaDivisoria()
                    RenglonSemanal("Mar", "\u26C5", "27°", "21°")
                    LineaDivisoria()
                    RenglonSemanal("Mie", "\uD83C\uDF27\uFE0F", "26°", "20°")
                    LineaDivisoria()
                    RenglonSemanal("Jue", "\u26C5", "25°", "19°")
                    LineaDivisoria()
                    RenglonSemanal("Vie", "\uD83C\uDF26\uFE0F", "24°", "18°")
                }
            }
        }
    }
}

@Composable
fun VistaPrincipal(alActualizar: () -> Unit) {
    val gradienteFondo = Brush.verticalGradient(
        colors = listOf(Color(0xFF72EAFF), Color(0xFF72C2FF), Color(0xFF003888))
    )
    Box(
        modifier = Modifier
            .background(gradienteFondo)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "El Salvador",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "25°C",
                fontSize = 60.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(32.dp))

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.7f),
                modifier = Modifier.size(90.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Card(
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.2f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    FichaClimatica("HUM", "65%")
                    FichaClimatica("VIENTO", "12 km/h")
                    FichaClimatica("LLUVIA", "10%")
                }
            }

            Spacer(modifier = Modifier.height(45.dp))

            Button(
                onClick = alActualizar,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFF01579B),
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(56.dp)
                    .width(180.dp)
            ) {
                Text(
                    text = "ACTUALIZAR",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun ControladorNavegacion() {
    var mostrarDetalles by remember { mutableStateOf(false) }

    if (!mostrarDetalles) {
        VistaPrincipal(alActualizar = { mostrarDetalles = true })
    } else {
        VistaDetallada()
    }
}

@Preview
@Composable
fun PrevisualizacionClima() {
    ClimaTheme {
        ControladorNavegacion()
    }
}

