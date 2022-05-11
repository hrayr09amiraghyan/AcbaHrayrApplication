package com.example.acbahrayrapplication.data.converter.implementation

import com.example.acbahrayrapplication.data.converter.DtoUIModelConverter
import com.example.acbahrayrapplication.data.dto.MaximumDto
import com.example.acbahrayrapplication.model.Maximum

typealias WeatherMaxUIModelConverter = DtoUIModelConverter<MaximumDto, Maximum>

class WeatherMaximumConverter : WeatherMaxUIModelConverter {

    override fun dtoToModel(dtoObject: MaximumDto): Maximum {
        return Maximum(
            dtoObject.Value,
            dtoObject.Unit
        )
    }
}