package com.cetacea.ui.vistas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavHostController
import com.cetacea.ui.modelos.Documental

@Composable
fun PantallaDocumentales(
    navController: NavHostController,
    documentales: List<Documental>
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Cabecera()

        // Cuerpo scrollable con LazyColumn
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0xFF007EA7),
                            Color(0xFF034078),
                            Color(0xFF001F54),
                        )
                    )
                ),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(documentales.size) { index ->
                TarjetaDocumental(documental = documentales[index])
            }
        }

        BarraNavegacion(navController)
    }
}

@Composable
fun TarjetaDocumental(documental: Documental) {
    val context = LocalContext.current

    // ExoPlayer para el video
    val exoPlayer = remember(documental.url) {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(documental.url))
            prepare()
            playWhenReady = false  // No reproducir automáticamente
        }
    }

    DisposableEffect(exoPlayer) {
        onDispose { exoPlayer.release() }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF0A1128),
                shape = RoundedCornerShape(30.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = documental.titulo,
            fontSize = 20.sp,
            color = Color(0xFFC6DAF1)
        )

        Spacer(modifier = Modifier.height(8.dp))

        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    useController = true  // Muestra controles
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )
    }
}

