package com.example.acbahrayrapplication.data.converter.implementation

import com.example.acbahrayrapplication.data.converter.DtoUIModelConverter
import com.example.acbahrayrapplication.data.dto.DailyForecastDto
import com.example.acbahrayrapplication.model.DailyForecast

typealias WeatherForecastUIModelConverter = DtoUIModelConverter<DailyForecastDto, DailyForecast>

class WeatherForecastConverter(private val temperatureConverter: TemperatureConverter) :
    WeatherForecastUIModelConverter {


    override fun dtoToModel(dtoObject: DailyForecastDto): DailyForecast {
        return DailyForecast(
            dtoObject.Date,
            temperatureConverter.dtoToModel(dtoObject.Temperature)
        )
    }


}