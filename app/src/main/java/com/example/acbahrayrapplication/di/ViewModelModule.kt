package com.example.acbahrayrapplication.di

import com.example.acbahrayrapplication.viewModel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WeatherViewModel(get()) }

}