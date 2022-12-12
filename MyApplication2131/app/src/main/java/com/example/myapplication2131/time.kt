package com.example.myapplication2131

import android.icu.util.TimeUnit
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import javax.xml.datatype.DatatypeConstants.SECONDS

class MainActivity352542 : ComponentActivity() {
    val time = MutableStateFlow(0)
    var timerJob: Job? = null

    val LabList = MutableStateFlow(emptyList<Int>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val labListValue = LabList.collectAsState().value
            Row() {
                Button(onClick = { startTimer() }) {
                    Text(text = "시작", fontSize = 20.sp)
                }
                Button(onClick = { stopTimer() }) {
                    Text(text = "종료", fontSize = 20.sp)
                }
                Button(onClick = { pauseTimer() }) {
                    Text(text = "일시정지", fontSize = 20.sp)
                }
                Button(onClick = {
                    LabList.value += time.value
                }) {
                    Text(text = "기록", fontSize = 20.sp)
                }


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    labListValue.forEachIndexed { index, i ->
                        BoxLayout5(index = index, time = i)


                    }


                }

            }



            Box(contentAlignment = Alignment.Center) {


                Box(
                    modifier = Modifier
                        .size(350.dp)
                        .size(340.dp)
                        .padding(top = 250.dp, start = 46.dp)
                        .background(color = Color.Black, shape = CircleShape)
                )
                Box(
                    modifier = Modifier
                        .size(303.dp)
                        .padding(top = 230.dp, start = 46.dp)
                        .background(color = Color.White, shape = CircleShape)
                )
            }
            BoxLayout15(time.collectAsState().value)
        }
    }

    fun startTimer() {
        if (timerJob == null)
            timerJob = CoroutineScope(Dispatchers.IO).launch {
                while (true) {
                    time.value++
                    delay(1000)
                }
            }
    }

    fun stopTimer() {
        time.value = 0
        timerJob?.cancel()
    }

    fun pauseTimer() {
        timerJob?.cancel()
        timerJob = null
    }


    @Composable
    fun BoxLayout5(index: Int, time: Int) {
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp)
                .alpha(0.8f)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(0.dp)
        )
        {
            Text(text = index.toString(), color = Color.Black, fontSize = 16.sp)
            Text(text = "초", color = Color.Gray, fontSize = 14.9.sp)
        }
    }

    @Composable
    fun BoxLayout15(sexy: Int) {
        Column(
            modifier = Modifier
                .padding(top = 260.dp)
                .fillMaxWidth()
                .padding(horizontal = 35.dp)
                .background(color = Color.Gray, shape = RoundedCornerShape(20.dp))
                .padding(13.dp)
        )
        {
            Text(text = sexy.convertHourMinSecFormat(), color = Color.Black, fontSize = 40.sp)
        }
    }
    fun Int.convertHourMinSecFormat(): String {
        val hour = this / 60 / 60
        val min = this / 60 % 60
        val sec = this % 60

        return String.format("%02d:%02d:%02d", hour, min, sec)
    }
}


