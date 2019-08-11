package com.brevitz.navigationcomponenttest.feature.home

import com.brevitz.navigationcomponenttest.feature.CoreComponent
import dagger.Component

@Component(dependencies = [CoreComponent::class])
interface HomeComponent {
    fun inject(fragment: HomeFragment)

    @Component.Builder
    interface Builder {
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): HomeComponent
    }
}
