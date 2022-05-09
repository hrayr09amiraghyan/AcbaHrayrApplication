package com.example.acbahrayrapplication.data.dto


data class DailyForecastDto(val Date: String, val Temperature: TemperatureDto)

data class TemperatureDto(val Minimum: MinimumDto, val Maximum: MaximumDto)

data class MinimumDto(val Value: Int, val Unit: String)
data class MaximumDto(val Value: Int, val Unit: String)
