package com.example.acbahrayrapplication.data.converter.implementation

import com.example.acbahrayrapplication.data.converter.DtoUIModelConverter
import com.example.acbahrayrapplication.data.dto.MinimumDto
import com.example.acbahrayrapplication.model.Minimum

typealias WeatherMinUIModelConverter = DtoUIModelConverter<MinimumDto, Minimum>

class WeatherMinimumConverter : WeatherMinUIModelConverter {

    override fun dtoToModel(dtoObject: MinimumDto): Minimum {
        return Minimum(
            dtoObject.Value,
            dtoObject.Unit
        )
    }
}