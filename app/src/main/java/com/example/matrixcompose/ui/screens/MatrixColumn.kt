package com.example.matrixcompose.ui.screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import com.example.matrixcompose.util.characters
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun RowScope.MatrixColumn(yStartDelay: Long, crawlSpeed: Long){

    // Cambiar el tamaño de las letras
    // BoxWithContrainst -> Nos permite saber el alto y ancho en pixeles para adaptarlo

    BoxWithConstraints(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()) {
        // Lista aleatoria de chars
        val matrixStrip = remember {
            // Calcular los elementos que ocupen todo el espacio disponible
            Array((maxHeight / maxWidth).toInt()){
                characters.random()
            }
        }

        var maxWidthDp = maxWidth
        var letterToDraw by remember {
            mutableIntStateOf(0)
        }
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            repeat(letterToDraw){
                MatrixChar(
                    fontSize = with(LocalDensity.current){maxWidthDp.toSp()},
                    matrixStrip[it],
                    crawlSpeed = crawlSpeed,
                    onFinished = {
                        if(it >= matrixStrip.size * 0.6)
                            letterToDraw = 0
                    }
                )

            }
        }

        LaunchedEffect(Unit) {
            delay(yStartDelay)
            while(true){
                if( letterToDraw < matrixStrip.size){
                    letterToDraw++
                }
                // Más de la mitad de letras pintadas, cambiar de forma aleatoria
                if(letterToDraw >= matrixStrip.size * 0.5){
                    matrixStrip[Random.nextInt(letterToDraw)] = characters.random()
                }
                delay(crawlSpeed)

            }
        }
    }

}