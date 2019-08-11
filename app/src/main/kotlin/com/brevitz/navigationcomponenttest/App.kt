package com.brevitz.navigationcomponenttest

import android.app.Application
import com.brevitz.navigationcomponenttest.core.CoreComponent
import com.brevitz.navigationcomponenttest.core.CoreComponentProvider
import com.brevitz.navigationcomponenttest.core.DaggerCoreComponent
import com.brevitz.navigationcomponenttest.core.data.NetworkModule
import timber.log.Timber

class App : Application(), CoreComponentProvider {
    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent.builder()
                .networkModule(NetworkModule)
                .build()
        }

        return coreComponent
    }
}
