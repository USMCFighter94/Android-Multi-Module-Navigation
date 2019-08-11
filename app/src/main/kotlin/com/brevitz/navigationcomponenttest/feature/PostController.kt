package com.brevitz.navigationcomponenttest.feature

import com.airbnb.epoxy.TypedEpoxyController
import com.brevitz.navigationcomponenttest.domain.Post

class PostController : TypedEpoxyController<List<Post>>() {
    override fun buildModels(data: List<Post>) {
        data.forEach {
            PostModel(it)
                .id(it.created)
                .addTo(this)
        }
    }
}
