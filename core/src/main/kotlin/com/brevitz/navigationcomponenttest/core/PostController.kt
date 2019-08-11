package com.brevitz.navigationcomponenttest.core

import com.airbnb.epoxy.TypedEpoxyController
import com.brevitz.navigationcomponenttest.core.domain.Post

class PostController : TypedEpoxyController<List<Post>>() {
    override fun buildModels(data: List<Post>) {
        data.forEach {
            PostModel(it)
                .id(it.created)
                .addTo(this)
        }
    }
}
