package com.brevitz.navigationcomponenttest.data

import com.brevitz.navigationcomponenttest.domain.Post
import com.brevitz.navigationcomponenttest.domain.Posts

data class RedditResponse(val data: DataResponse) {
    fun toPosts() = Posts(
        data.children.map {
            val child = it.data
            Post(
                child.author,
                child.title,
                child.preview,
                child.subredditPrefix,
                child.numberOfComments,
                child.created,
                child.thumbnail,
                child.url,
                child.upVotes,
                child.downVotes
            )
        },
        data.before,
        data.after
    )
}
