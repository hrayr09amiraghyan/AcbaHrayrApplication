package com.example.acbahrayrapplication.data.converter.implementation

import com.example.acbahrayrapplication.data.converter.DtoUIModelConverter
import com.example.acbahrayrapplication.data.dto.WeatherDto
import com.example.acbahrayrapplication.model.WeatherModel

typealias WeatherDtoUIModelConverter = DtoUIModelConverter<WeatherDto, WeatherModel>

class WeatherConverter(private val weatherForecastConverter: WeatherForecastConverter) :
    WeatherDtoUIModelConverter {

    override fun dtoToModel(dtoObject: WeatherDto): WeatherModel {
        return WeatherModel(
            dtoObject.DailyForecasts.map { weatherForecastConverter.dtoToModel(it) },
        )
    }

}