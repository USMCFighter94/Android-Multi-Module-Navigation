package com.brevitz.navigationcomponenttest.feature

import com.brevitz.navigationcomponenttest.data.NetworkModule
import com.brevitz.navigationcomponenttest.feature.home.HomeFragment
import com.brevitz.navigationcomponenttest.feature.subreddit.SubRedditFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface CoreComponent {
    fun inject(fragment: HomeFragment)
    fun inject(fragment: SubRedditFragment)

    @Component.Builder
    interface Builder {
        fun networkModule(module: NetworkModule): Builder
        fun build(): CoreComponent
    }
}
