package com.example.matrixcompose.ui.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import kotlinx.coroutines.delay

@Composable
fun MatrixChar(fontSize: TextUnit,char: String, crawlSpeed: Long, onFinished: () -> Unit){

    // Color inicial
    var textColor by remember {
        mutableStateOf(Color(0xffcefbe4))
    }
    var startFade by remember {
        mutableStateOf(false)
    }

    // Estado con animación
    val alpha by animateFloatAsState(
        targetValue = if (startFade) 0f else 1f,
        label = "",
        animationSpec = tween(
            durationMillis = 4000,
            easing = LinearEasing
        ),
        finishedListener = { onFinished()}
    )

    Text(
        text = char,
        color = textColor.copy(alpha = alpha),
        fontSize = fontSize
    )

    // Solo se lanza una vez durante la vida del MatrixChar
    LaunchedEffect(Unit) {
        // Velocidad de barrido de los chars
        delay(crawlSpeed)
        textColor = Color(0xff43c728)
        startFade = true

    }
}