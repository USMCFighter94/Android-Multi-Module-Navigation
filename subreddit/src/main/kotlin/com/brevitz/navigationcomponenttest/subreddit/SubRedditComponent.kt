package com.brevitz.navigationcomponenttest.subreddit

import com.brevitz.navigationcomponenttest.core.CoreComponent
import com.brevitz.navigationcomponenttest.core.FeatureScope
import dagger.Component

@FeatureScope
@Component(dependencies = [CoreComponent::class])
interface SubRedditComponent {
    fun inject(fragment: SubRedditFragment)
}
