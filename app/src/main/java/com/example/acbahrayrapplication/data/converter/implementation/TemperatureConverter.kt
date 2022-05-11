package com.example.acbahrayrapplication.data.converter.implementation

import com.example.acbahrayrapplication.data.converter.DtoUIModelConverter
import com.example.acbahrayrapplication.data.dto.TemperatureDto
import com.example.acbahrayrapplication.model.Temperature

typealias WeatherTemperatureUIModelConverter = DtoUIModelConverter<TemperatureDto, Temperature>

class TemperatureConverter(
    private val maximumConverter: WeatherMaximumConverter,
    private val minConverter: WeatherMinimumConverter
) : WeatherTemperatureUIModelConverter {


    override fun dtoToModel(dtoObject: TemperatureDto): Temperature {
        return Temperature(
            minConverter.dtoToModel(dtoObject.Minimum),
            maximumConverter.dtoToModel(dtoObject.Maximum)
        )
    }

}