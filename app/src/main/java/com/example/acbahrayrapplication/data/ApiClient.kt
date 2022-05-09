package com.example.acbahrayrapplication.data

import com.example.acbahrayrapplication.data.dto.WeatherDto
import com.example.acbahrayrapplication.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @GET("forecasts/v1/daily/1day/{locationKey}")
    suspend fun getWatherForecastForOneDay(
        @Path("locationKey") id: Long,
        @Query("apikey") apikey: String
    ): WeatherDto
}