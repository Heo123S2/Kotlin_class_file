package com.example.myapplication2131

import android.view.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat


@Composable
fun IP(window: Window) {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ip),
            contentDescription = "배경 이미지",
            Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.padding(vertical = 48.dp)) {
            Image(
                imageVector = Icons.Rounded.Lock,
                contentDescription = "잠금",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .padding(top = 7.dp, start = 16.dp)
                    .size(65.dp))
            ColumnLayout1()
            ColumnLayout11()
            BoxLayout14()
            Box(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                CircleButton(imageVector = Icons.Rounded.Call)
                CircleButton(imageVector = Icons.Rounded.Email)
            }
        }
    }
}


@Composable
fun CircleButton(imageVector: ImageVector, contentDescription: String? = null) {
    Box(
        modifier = Modifier.
        background(color = Color(0x88000000),
            CircleShape)
            .padding(10.dp),
        contentAlignment = Alignment.Center) { Image(imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = Modifier.size(30.dp),
        colorFilter = ColorFilter.tint(Color.White)
    )
    }
}
@Preview
@Composable
fun BoxLayoutPreview() {
    BoxLayout14()
}

@Composable
fun BoxLayout14() {
    Column(
        modifier = Modifier
            .padding(top = 14.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .alpha(0.8f)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .padding(13.dp)
    )
    {
        Text(text = "2학년 5반 이름: 허명호", color = Color.Black, fontSize = 16.sp)
        Text(text = "집 가고 싶다~", color = Color.Gray, fontSize = 14.9.sp)
    }



}

@Preview
@Composable
fun ColummLayout1() {
    ColumnLayout1()
}

@Composable
fun ColumnLayout1() {
    Box(
        modifier = Modifier
            .padding()
            .fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        Text(text = "09:54", color = Color.White, fontSize = 90.sp)
    }
}

@Composable
fun ColumnLayout11() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 0.dp, start = 110.dp),
    ) {
        Text(text = "7월 16일 토요일", color = Color.White, fontSize = 24.sp)

    }
}

@Preview
@Composable
fun ColumnLayoutP() {
    ColumnLayout11()
}