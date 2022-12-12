package com.example.myapplication

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.myapplication.models.forecast.ForecastWeatherResponse
import com.example.myapplication.models.weather.WeatherResponse
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    val locationManager = LocationManager(this)

    val weatherResponse = MutableStateFlow<WeatherResponse?>(null)
    val forecastWeatherResponse = MutableStateFlow<ForecastWeatherResponse?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(R.drawable.icon32),
                    contentDescription = "123",
                    Modifier
                        .fillMaxHeight()
                        .fillMaxSize()
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillBounds
                )
                Box(
                    modifier = Modifier
                        .padding(top = 60.dp, start = 21.dp)
                        .alpha(0.6f)
                        .background(color = Color.DarkGray, RoundedCornerShape(10.dp))
                        .size(350.dp)
                )
                val weatherResponse = weatherResponse.collectAsState().value
                val forecastWeatherResponse = forecastWeatherResponse.collectAsState().value

                if (weatherResponse != null) {
                    Column(
                    ) {

                        Box(
                            modifier = Modifier
                                .padding(top = 70.dp, start = 22.dp)
                                .size(350.dp)
                        ) {
                        }

                        Row(
                            modifier = Modifier.size(width = 150.dp, height = 0.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(top = 15.dp, start = 110.dp)
                                    .padding(horizontal = 0.dp)
                            ) {


                            }
                        }

                    }
                    Column(
                        modifier = Modifier
                            .padding(top = 66.dp, start = 150.dp)
                            .alpha(0.96f)
                    ) {
                        if (weatherResponse == null) {
                            Text(
                                text = "지역 정보를 불러오고 있습니다.",
                                color = Color.Gray
                            )
                        } else {
                            Text(
                                modifier = Modifier, fontSize = 25.sp,
                                text = "${(weatherResponse.name)}",
                                color = Color.White,
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(top = 100.dp, start = 140.dp)
                    ) {
                        Text(
                            fontSize = 30.sp,
                            text = "현재 온도",
                            color = Color.White
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(top = 115.dp, start = 125.dp)
                            .alpha(0.5f)
                    )
                    {
                        Text(
                            fontSize = 30.sp,
                            text = "___________"
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(
                                top = 177.dp,
                                start = 123.dp
                            )
                            .alpha(0.96f)
                    ) {
                        if (weatherResponse == null) {
                            Text(
                                text = "날씨 정보를 불러오고 있습니다.",
                                color = Color.Gray
                            )
                        } else {
                            Text(
                                modifier = Modifier, fontSize = 80.sp,
                                text = "${(weatherResponse.main.temp - 273.15).toInt()}℃",
                                color = Color.White,
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(top = 280.dp, start = 125.dp)
                            .alpha(0.5f)
                    ) {
                        Text(
                            fontSize = 30.sp,
                            text = "___________"
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(top = 280.dp, start = 125.dp)
                            .alpha(0.5f)
                    ) {
                        Text(
                            fontSize = 30.sp,
                            text = "___________"
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(top = 280.dp, start = 106.dp)
                            .alpha(1f)
                    ) {
                        Text(
                            text = "위도 / ${(weatherResponse.coord.lat)} 경도 / ${weatherResponse.coord.lon}",
                            color = Color.Cyan
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 460.dp)
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .alpha(0.8f)
                            .padding(13.dp)
                    ) {
                        if (forecastWeatherResponse != null) {
                            forecastWeatherResponse.list.forEach {
                                Column(
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(10.dp)
                                ) {
                                    Text(text = "${(it.main.temp - 273.15).toInt()}℃")
                                    Text(
                                        text = "${epochSecondToPatternString(it.dt, "YYYY:hh:MM")}",
                                        color = Color.Cyan
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        getWeather()
        getForecastWeather()
    }

    fun getWeather() {
        locationManager.getLocation(
            onPermissionDenied = {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)
        }, onCurrentLocation = {
            CoroutineScope(Dispatchers.IO).launch {
                weatherResponse.value =
                    KtorManager.httpClient.get<WeatherResponse>("https://api.openweathermap.org/data/2.5/weather?lat=${it.latitude}&lon=${it.longitude}&appid=1790b1de6db19fc7274e9346497a1b1f")
        }
    })
    }

    fun getForecastWeather() {
        locationManager.getLocation(
            onPermissionDenied = {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)
        }, onCurrentLocation = {
            CoroutineScope(Dispatchers.IO).launch {
                forecastWeatherResponse.value =
                    KtorManager.httpClient.get<ForecastWeatherResponse>("https://api.openweathermap.org/data/2.5/forecast?lat=${it.latitude}&lon=${it.longitude}&appid=1790b1de6db19fc7274e9346497a1b1f")
        }
    }
        )
    }

    private fun epochSecondToStringFormat(dt: Long): String =
        Instant.ofEpochSecond(dt)
            .atZone(ZoneId.systemDefault()).toLocalDateTime().format(
                DateTimeFormatter.ofPattern("H:mm")
//                DateTimeFormatter.ofPattern("h.mm a")
            )

    private fun epochSecondToPatternString(dt: Long, pattern: String): String =
        Instant.ofEpochSecond(dt)
            .atZone(ZoneId.systemDefault()).toLocalDateTime().format(
                DateTimeFormatter.ofPattern(pattern)
//                DateTimeFormatter.ofPattern("h.mm a")
            )
}

