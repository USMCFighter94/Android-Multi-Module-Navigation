package com.brevitz.navigationcomponenttest

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}
