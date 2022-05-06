package com.example.acbahrayrapplication.di

import com.example.acbahrayrapplication.data.ApiClient
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


val networkModule = module {

    single { provideOkHttp() }
    single { provideRetrofitClient(get()) }
    single { provideApiService(get(), ApiClient::class.java) }
}

private fun provideOkHttp() =
    OkHttpClient.Builder()
        .build()

private fun provideRetrofitClient(okHttpClient: OkHttpClient) =
    Retrofit.Builder()
        .baseUrl("http://dataservice.accuweather.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

private fun <T> provideApiService(retrofit: Retrofit, clazz: Class<T>): T {
    return retrofit.create(clazz)
}


