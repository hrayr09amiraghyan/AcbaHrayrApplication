package com.example.acbahrayrapplication.repo.repoImpl

import com.example.acbahrayrapplication.data.ApiClient
import com.example.acbahrayrapplication.data.converter.implementation.WeatherConverter
import com.example.acbahrayrapplication.model.WeatherModel
import com.example.acbahrayrapplication.repo.WeatherRepo
import com.example.acbahrayrapplication.util.Response
import com.example.acbahrayrapplication.util.ResponseHandler

class WeatherRepoImpl(
    val apiClient: ApiClient,
    private val weatherConverter: WeatherConverter,
    private val responseHandler: ResponseHandler
) :
    WeatherRepo {

    override suspend fun getWeatherData(
        id: Long,
        apiKey: String
    ): Response<WeatherModel> {

        return try {
            val data = apiClient.getWatherForecastForOneDay(id, apiKey)
            responseHandler.handleSuccess(weatherConverter.dtoToModel(data))
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }

    }
}