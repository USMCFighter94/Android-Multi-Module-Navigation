package com.brevitz.navigationcomponenttest.domain

import io.reactivex.Single

sealed class RemoteState<out S : Any> {
    object Loading : RemoteState<Nothing>()
    data class Success<S : Any>(val data: S) : RemoteState<S>()
    data class Error(val error: Throwable) : RemoteState<Nothing>()
}

fun <T : Any, S : Any> Single<RemoteState<T>>.mapToData(f: (T) -> S): Single<RemoteState<S>> =
    map {
        when (it) {
            is RemoteState.Success -> RemoteState.Success(f(it.data))
            is RemoteState.Error -> RemoteState.Error(it.error)
            is RemoteState.Loading -> RemoteState.Loading
        }
    }
