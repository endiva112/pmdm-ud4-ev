package com.cetacea.ui.vistas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun PantallaDocumentales(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Cabecera()

        // Cuerpo temporal (después pondrás los vídeos aquí)
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF007EA7),
                            Color(0xFF034078),
                            Color(0xFF001F54),
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Documentales",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC6DAF1)
            )
        }

        BarraNavegacion(navController)
    }
}