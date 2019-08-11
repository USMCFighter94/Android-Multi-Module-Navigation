package com.brevitz.navigationcomponenttest.feature

import com.brevitz.navigationcomponenttest.data.NetworkModule
import dagger.Component

@Component(modules = [NetworkModule::class])
interface CoreComponent {
    @Component.Builder
    interface Builder {
        fun networkModule(module: NetworkModule): Builder
        fun build(): CoreComponent
    }
}
