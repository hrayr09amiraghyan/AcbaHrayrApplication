package com.example.acbahrayrapplication.di

import com.example.acbahrayrapplication.repo.WeatherRepo
import com.example.acbahrayrapplication.repo.repoImpl.WeatherRepoImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<WeatherRepo> { WeatherRepoImpl(get(), get()) }
}