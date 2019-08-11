package com.brevitz.navigationcomponenttest.core.domain

data class Post(
    val author: String,
    val title: String,
    val preview: String,
    val subredditPrefix: String,
    val numberOfComments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String,
    val upVotes: Int,
    val downVotes: Int
)
