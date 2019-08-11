package com.brevitz.navigationcomponenttest.feature

import com.brevitz.navigationcomponenttest.data.NetworkModule
import com.brevitz.navigationcomponenttest.feature.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface CoreComponent {
    fun inject(fragment: HomeFragment)

    @Component.Builder
    interface Builder {
        fun networkModule(module: NetworkModule): Builder
        fun build(): CoreComponent
    }
}
