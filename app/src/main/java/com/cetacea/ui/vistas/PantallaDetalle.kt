package com.cetacea.ui.vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cetacea.ui.modelos.Especie

@Composable
fun PantallaDetalle(ballena: Especie, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF007EA7),
                        Color(0xFF034078),
                        Color(0xFF001F54),
                    )
                )
            )
            .padding(16.dp)
    ) {
        // Botón para volver
        Text(
            text = "← Volver",
            color = Color(0xFFC6DAF1),
            fontSize = 16.sp,
            modifier = Modifier
                .clickable { navController.popBackStack() }
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Imagen grande
        Image(
            painter = painterResource(id = ballena.imagenRes),
            contentDescription = ballena.nombre,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Nombre
        Text(
            text = ballena.nombre,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFC6DAF1)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Descripción
        Text(
            text = ballena.descripcion,
            fontSize = 18.sp,
            color = Color(0xFFC6DAF1),
            lineHeight = 24.sp
        )
    }
}