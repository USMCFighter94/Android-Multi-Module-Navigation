package com.brevitz.navigationcomponenttest.domain

data class Posts(
    val children: List<Post>,
    val before: String,
    val after: String
)
