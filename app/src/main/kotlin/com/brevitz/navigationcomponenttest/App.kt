package com.brevitz.navigationcomponenttest

import android.app.Application
import com.brevitz.navigationcomponenttest.data.NetworkModule
import com.brevitz.navigationcomponenttest.feature.CoreComponent
import com.brevitz.navigationcomponenttest.feature.DaggerCoreComponent
import timber.log.Timber

class App : Application() {
    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        if (!::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent.builder()
                .networkModule(NetworkModule)
                .build()
        }
    }
}
