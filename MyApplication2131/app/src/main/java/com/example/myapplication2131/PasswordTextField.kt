package com.example.myapplication2131

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun PasswordTextField() {
    val context = LocalContext.current
    val password = remember {
        mutableStateOf("")
    }
    TextField(
        value = password.value,
        onValueChange = {
            password.value = it
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(color = Color.Black),
        label = {
            Text(text = "비밀번호", color = Color.Blue)
        },
        placeholder = {
            Text(text = "비밀번호", color = Color.Gray)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            Toast.makeText(context, "비밀번호: ${password.value}", Toast.LENGTH_SHORT).show()
        })
    )
}