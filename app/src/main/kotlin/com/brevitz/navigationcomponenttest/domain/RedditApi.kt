package com.brevitz.navigationcomponenttest.domain

import com.brevitz.navigationcomponenttest.data.RedditResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RedditApi {
    @GET(".json")
    fun getFrontPage(@Query("after") after: String): Single<Response<RedditResponse>>

    @GET("r/{subreddit}/.json")
    fun getSubreddit(@Path("subreddit") subReddit: String, @Query("after") after: String): Single<Response<RedditResponse>>
}
