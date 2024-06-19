package com.example.matrixcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.matrixcompose.ui.MatrixApp
import com.example.matrixcompose.ui.screens.MatrixRain

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatrixApp {
                MatrixRain()
            }
        }
    }
}

