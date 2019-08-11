package com.brevitz.navigationcomponenttest.core

import com.brevitz.navigationcomponenttest.core.data.NetworkModule
import com.brevitz.navigationcomponenttest.core.domain.RedditApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface CoreComponent {
    fun getRedditApi(): RedditApi
}
