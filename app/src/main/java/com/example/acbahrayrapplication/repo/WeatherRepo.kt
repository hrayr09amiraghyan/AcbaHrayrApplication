package com.example.acbahrayrapplication.repo

import com.example.acbahrayrapplication.model.WeatherModel
import com.example.acbahrayrapplication.util.Response

interface WeatherRepo {
    suspend fun getWeatherData(id: Long, apiKey: String): Response<WeatherModel>
}