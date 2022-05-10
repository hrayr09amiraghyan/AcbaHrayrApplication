package com.example.acbahrayrapplication.di

import com.example.acbahrayrapplication.repo.WeatherRepo
import com.example.acbahrayrapplication.repo.repoImpl.WeatherRepoImpl
import com.example.acbahrayrapplication.util.ResponseHandler
import org.koin.dsl.module

val repositoryModule = module {
    single { ResponseHandler() }
    single<WeatherRepo> { WeatherRepoImpl(get(), get(), get()) }
}