package com.brevitz.navigationcomponenttest.data.subreddit

import com.brevitz.navigationcomponenttest.data.mapToRemoteState
import com.brevitz.navigationcomponenttest.domain.Posts
import com.brevitz.navigationcomponenttest.domain.RedditApi
import com.brevitz.navigationcomponenttest.domain.RemoteState
import com.brevitz.navigationcomponenttest.domain.mapToData
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class SubRedditRepository @Inject constructor(private val api: RedditApi) {
    fun getData(subReddit: String, after: String): Observable<RemoteState<Posts>> =
        api.getSubreddit(subReddit, after)
            .mapToRemoteState()
            .mapToData { it.toPosts() }
            .doOnError { Timber.e(it) }
            .toObservable()
            .startWith(RemoteState.Loading)
}
