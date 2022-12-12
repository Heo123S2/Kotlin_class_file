package com.example.myapplication2131

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ColumnLayout() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "2학년 5반 16번  이름: 허명호")
        Text(text = "진")
        Text(text = "용")
        Text(text = "주")
    }
}
@Preview
@Composable
fun ColumnLayoutPreview() {

    ColumnLayout()
}
