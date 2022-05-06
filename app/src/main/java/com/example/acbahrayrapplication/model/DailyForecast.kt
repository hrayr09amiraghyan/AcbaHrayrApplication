package com.example.acbahrayrapplication.model

data class DailyForecast(val Date: String, val Temperature: Temperature)

data class Temperature(val Minimum: Minimum, val Maximum: Maximum)

data class Minimum(val Value: Int, val Unit: String)
data class Maximum(val Value: Int, val Unit: String)

