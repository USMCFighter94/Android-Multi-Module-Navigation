package com.brevitz.navigationcomponenttest.subreddit.data

import com.brevitz.navigationcomponenttest.core.ViewModel
import com.brevitz.navigationcomponenttest.core.domain.Posts
import com.brevitz.navigationcomponenttest.core.domain.ViewState
import com.brevitz.navigationcomponenttest.core.domain.doOnSuccess
import com.brevitz.navigationcomponenttest.core.domain.mapToViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SubRedditViewModel @Inject constructor(private val repository: SubRedditRepository) : ViewModel<Posts, Throwable>() {
    var subreddit = ""
    private var startingPost = ""

    fun getPosts() {
        repository.getData(subreddit, startingPost)
            .mapToViewState()
            .doOnSuccess { startingPost = it.after }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { state -> updateState { state } },
                { error -> updateState { ViewState.Error(error) } })
            .addTo(disposables)
    }
}
