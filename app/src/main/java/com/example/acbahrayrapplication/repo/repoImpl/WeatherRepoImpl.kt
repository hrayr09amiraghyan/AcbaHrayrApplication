package com.example.acbahrayrapplication.repo.repoImpl

import com.example.acbahrayrapplication.data.ApiClient
import com.example.acbahrayrapplication.data.converter.implementation.WeatherConverter
import com.example.acbahrayrapplication.model.WeatherModel
import com.example.acbahrayrapplication.repo.WeatherRepo
import com.example.acbahrayrapplication.util.Response

class WeatherRepoImpl(
    val apiClient: ApiClient,
    private val weatherConverter: WeatherConverter,
) :
    WeatherRepo {

    override suspend fun getWeatherData(
        id: Long,
        apiKey: String
    ): Response<WeatherModel> {

        return try {
            val data = apiClient.getWatherForecastForOneDay(id, apiKey)
            Response.Success(weatherConverter.dtoToModel(data))
        } catch (e: Exception) {
            Response.Error(e.message)
        }

    }
}