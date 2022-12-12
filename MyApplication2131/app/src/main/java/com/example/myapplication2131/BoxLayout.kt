package com.example.myapplication2131

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoxLayout1() {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
                .size(size = 50.dp)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(width = 30.dp, height = 10.dp)
                    .background(Color.White)
            )
            Box(
                modifier = Modifier
                    .size(width = 10.dp, height = 30.dp)
                    .background(Color.White)           )
        }
    }
}