package com.brevitz.navigationcomponenttest.home

import com.brevitz.navigationcomponenttest.core.CoreComponent
import com.brevitz.navigationcomponenttest.core.FeatureScope
import dagger.Component

@FeatureScope
@Component(dependencies = [CoreComponent::class])
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}
