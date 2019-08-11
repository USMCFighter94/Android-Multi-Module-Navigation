package com.brevitz.navigationcomponenttest.data

import com.brevitz.navigationcomponenttest.domain.RedditApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory = MoshiConverterFactory.create(
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    )

    @Provides
    @Singleton
    fun callAdapter(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun retrofit(callAdapterFactory: CallAdapter.Factory, converterFactory: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.reddit.com/")
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .build()

    @Provides
    @Singleton
    fun redditApi(retrofit: Retrofit): RedditApi = retrofit.create(RedditApi::class.java)
}
