package com.brevitz.navigationcomponenttest.core.domain

data class Posts(
    val children: List<Post>,
    val before: String,
    val after: String
)
