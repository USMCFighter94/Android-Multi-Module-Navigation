package com.brevitz.navigationcomponenttest.feature.home

import com.brevitz.navigationcomponenttest.core.ViewModel
import com.brevitz.navigationcomponenttest.core.domain.Posts
import com.brevitz.navigationcomponenttest.core.domain.ViewState
import com.brevitz.navigationcomponenttest.core.domain.doOnSuccess
import com.brevitz.navigationcomponenttest.core.domain.mapToViewState
import com.brevitz.navigationcomponenttest.data.home.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel<Posts, Throwable>() {
    private var startingPost = ""

    fun getPosts() {
        repository.getData(startingPost)
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
