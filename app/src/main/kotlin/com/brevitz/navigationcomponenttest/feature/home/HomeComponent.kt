package com.brevitz.navigationcomponenttest.feature.home

import com.brevitz.navigationcomponenttest.core.CoreComponent
import com.brevitz.navigationcomponenttest.core.FeatureScope
import dagger.Component

@Component(dependencies = [CoreComponent::class])
@FeatureScope
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}
