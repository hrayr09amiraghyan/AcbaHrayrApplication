package com.example.acbahrayrapplication.di

import com.example.acbahrayrapplication.data.converter.implementation.*
import org.koin.dsl.module

val converterModule = module {
    single { WeatherConverter(get()) }
    single { TemperatureConverter(get(), get()) }
    single { WeatherForecastConverter(get()) }
    single { WeatherMinimumConverter() }
    single { WeatherMaximumConverter() }
}