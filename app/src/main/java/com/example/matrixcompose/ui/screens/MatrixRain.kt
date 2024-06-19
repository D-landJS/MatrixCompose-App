package com.example.matrixcompose.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import kotlin.random.Random

@Composable
fun MatrixRain(stripCount: Int = 20){
    Row{
        repeat(stripCount){
            MatrixColumn(
                yStartDelay = Random.nextInt(8) * 1000L,
                crawlSpeed = (Random.nextInt(10 ) + 10L) + 100
            )
        }
    }
}
