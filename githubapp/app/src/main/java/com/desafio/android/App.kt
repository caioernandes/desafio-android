package com.desafio.android

import android.app.Application
import androidx.multidex.BuildConfig
import com.desafio.android.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

open class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(androidContext = this@App)
            modules(provideDependency())
        }
    }

    open fun provideDependency() = appComponent
}
