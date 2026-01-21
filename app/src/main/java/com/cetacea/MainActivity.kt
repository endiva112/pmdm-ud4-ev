package com.cetacea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CetaceaAppPreview()
        }
    }
}

// Data class para las ballenas
data class Especie(
    val nombre: String,
    val imagenRes: Int,
    val descripcion: String = "Descripción de la ballena"
)

// Lista de ballenas de ejemplo
val listaBallenas = listOf(
    Especie("Orcinus orca", R.drawable.orcinus_orca, "La orca es el delfín más grande del mundo"),
    Especie("Ballena Azul", R.drawable.orcinus_orca, "El animal más grande que ha existido"),
    Especie("Ballena Jorobada", R.drawable.orcinus_orca, "Conocida por sus complejos cantos")
)

@Composable
fun CetaceaApp() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize() // Ocupa toda la pantalla
        ) {
            Cabecera()
            // weight(1f) hace que se ocupe completamente el espacio sobrante
            Cuerpo(modifier = Modifier.weight(1f))

            BarraNavegacion()
        }
    }
}

@Composable
fun Cabecera() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0A1128))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Cetacea",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFC6DAF1)
        )
    }
}

@Composable
fun Cuerpo(modifier: Modifier = Modifier) {
    // LazyColumn es como Column pero scrolleable y eficiente
    // Solo renderiza los elementos visibles
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .background(
                //degradado
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF007EA7),
                        Color(0xFF034078),
                        Color(0xFF001F54),
                    )
                )
            ),
        contentPadding = PaddingValues(16.dp), // Padding alrededor de todo
        verticalArrangement = Arrangement.spacedBy(16.dp) // Separación entre tarjetas
    ) {
        // Genera 10 tarjetas (puedes poner las que quieras)
        items(3) { index ->
            Tarjeta()
        }
    }
}

@Composable
fun BarraNavegacion() {
    // Row apila elementos horizontalmente (lado a lado)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0A1128))
            .padding(8.dp)
    ) {
        // Botón 1 (ocupa la mitad)
        Box(
            modifier = Modifier
                .weight(1f) // Ocupa la mitad del espacio
                .height(50.dp)
                .clickable { /* Acción al hacer click */ },
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Especies",
                color = Color(0xFFC6DAF1),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.width(8.dp)) // Separación entre botones

        // Botón 2 (ocupa la otra mitad)
        Box(
            modifier = Modifier
                .weight(1f)
                .height(50.dp)
                .clickable { /* Acción al hacer click */ },
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Documentales",
                color = Color(0xFFC6DAF1),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun Tarjeta() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF0A1128),
                shape = RoundedCornerShape(30.dp)
            )
            .padding(20.dp, 10.dp), // Padding interno de la tarjeta
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.orcinus_orca),
            contentDescription = "Orca",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Orcinus orca",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFC6DAF1),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CetaceaAppPreview() {
    CetaceaApp()
}