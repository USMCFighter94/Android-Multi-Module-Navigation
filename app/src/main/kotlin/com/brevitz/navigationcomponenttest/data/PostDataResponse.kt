package com.brevitz.navigationcomponenttest.data

import com.squareup.moshi.Json

data class PostDataResponse(
    val author: String,
    val title: String,
    @Json(name = "selftext") val preview: String,
    @Json(name = "subreddit_name_prefixed") val subredditPrefix: String,
    @Json(name = "num_comments") val numberOfComments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String,
    @Json(name = "ups") val upVotes: Int,
    @Json(name = "downs") val downVotes: Int
)
