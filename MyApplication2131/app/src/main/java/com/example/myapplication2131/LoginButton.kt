package com.example.myapplication2131

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton() {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "로그인 버튼 클릭", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier.size(width = 100.dp, height = 40.dp),
        shape = RoundedCornerShape(100.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black),
        content = {
            Text(text = "로그인")
        },
    )
}
@Preview
@Composable
fun LoginButtonPreview() {
    LoginButton()
}