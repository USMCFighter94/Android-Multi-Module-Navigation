package com.brevitz.navigationcomponenttest

import android.app.Application
import com.brevitz.navigationcomponenttest.data.NetworkModule
import com.brevitz.navigationcomponenttest.feature.CoreComponent
import com.brevitz.navigationcomponenttest.feature.DaggerCoreComponent

class App : Application() {
    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        if (!::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent.builder()
                .networkModule(NetworkModule)
                .build()
        }
    }
}
