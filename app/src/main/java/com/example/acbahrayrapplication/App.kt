package com.example.acbahrayrapplication

import android.app.Application
import com.example.acbahrayrapplication.di.converterModule
import com.example.acbahrayrapplication.di.networkModule
import com.example.acbahrayrapplication.di.repositoryModule
import com.example.acbahrayrapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    viewModelModule,
                    converterModule,
                    repositoryModule
                )
            )
        }
    }
}