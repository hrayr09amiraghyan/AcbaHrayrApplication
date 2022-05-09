package com.example.acbahrayrapplication.di

import com.example.acbahrayrapplication.data.converter.implementation.TemperatureConverter
import com.example.acbahrayrapplication.data.converter.implementation.WeatherConverter
import com.example.acbahrayrapplication.data.converter.implementation.WeatherForecastConverter
import com.example.acbahrayrapplication.data.converter.implementation.WeatherMinimumConverter
import org.koin.dsl.module

val converterModule = module {
    single { WeatherConverter(get()) }
    single { TemperatureConverter(get(), get()) }
    single { WeatherForecastConverter(get()) }
    single { WeatherMinimumConverter() }
    single { WeatherMinimumConverter() }
}