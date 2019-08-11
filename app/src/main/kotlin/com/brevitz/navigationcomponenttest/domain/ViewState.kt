package com.brevitz.navigationcomponenttest.domain

import io.reactivex.Observable

sealed class ViewState<out S : Any, out E : Any> {
    object Loading : ViewState<Nothing, Nothing>()
    data class Success<S : Any>(val data: S) : ViewState<S, Nothing>()
    data class Error<E : Any>(val error: E) : ViewState<Nothing, E>()
}

fun <T : Any> Observable<RemoteState<T>>.mapToViewState(): Observable<ViewState<T, Throwable>> =
    map {
        when (it) {
            is RemoteState.Success -> ViewState.Success(it.data)
            is RemoteState.Error -> ViewState.Error(it.error)
            is RemoteState.Loading -> ViewState.Loading
        }
    }
