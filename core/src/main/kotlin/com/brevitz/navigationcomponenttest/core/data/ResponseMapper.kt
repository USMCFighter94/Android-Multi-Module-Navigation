package com.brevitz.navigationcomponenttest.core.data

import com.brevitz.navigationcomponenttest.core.domain.RemoteState
import io.reactivex.Single
import retrofit2.Response

fun <T : Any> Single<Response<T>>.mapToRemoteState(): Single<RemoteState<T>> =
    map {
        if (it.isSuccessful) {
            if (it.body() != null) {
                RemoteState.Success(it.body()!!)
            } else {
                RemoteState.Error(Throwable("Data was null!"))
            }
        } else {
            RemoteState.Error(Throwable(it.errorBody()?.string().orEmpty()))
        }
    }
