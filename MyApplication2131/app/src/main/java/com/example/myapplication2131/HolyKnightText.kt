package com.example.myapplication2131

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HolyKnightText() {
    Text(
        text = "HolyKnight",
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.End,
    )
}

@Preview(widthDp = 150)
@Composable
fun HolyKnightTextPreview() {
    HolyKnightText()
}
