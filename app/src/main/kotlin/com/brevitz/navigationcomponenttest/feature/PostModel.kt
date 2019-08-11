package com.brevitz.navigationcomponenttest.feature

import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.EpoxyModelWithView
import com.brevitz.navigationcomponenttest.R
import com.brevitz.navigationcomponenttest.domain.Post
import com.brevitz.navigationcomponenttest.hide
import com.brevitz.navigationcomponenttest.inflate
import com.brevitz.navigationcomponenttest.load
import kotlinx.android.synthetic.main.card_home.view.*

data class PostModel(private val post: Post) : EpoxyModelWithView<CardView>() {
    override fun bind(view: CardView) {
        super.bind(view)
        with(view) {
            if (post.thumbnail.isNotEmpty()) {
                postImage.load(post.thumbnail)
            } else {
                postImage.hide()
            }
            postTitle.text = post.title
            postAuthor.text = post.author
            postSubReddit.text = post.subredditPrefix
            postPreview.text = post.preview
            postUpvotes.text = post.upVotes.toString()
        }
    }

    override fun buildView(parent: ViewGroup): CardView = parent.inflate(R.layout.card_home) as CardView
}
