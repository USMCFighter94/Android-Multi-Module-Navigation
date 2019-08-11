package com.brevitz.navigationcomponenttest.core

import com.brevitz.navigationcomponenttest.core.domain.ViewState
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import kotlin.properties.Delegates

abstract class ViewModel<S : Any, E : Any>(initialState: ViewState<S, E> = ViewState.Loading) {
    val disposables = CompositeDisposable()

    private val stateSubject = BehaviorSubject.createDefault(initialState)
    private var state: ViewState<S, E> by Delegates.observable(initialState) { _, _, newState ->
        stateSubject.onNext(newState)
    }

    fun updateState(f: (ViewState<S, E>) -> ViewState<S, E>) {
        state = f(state)
    }

    fun currentState(): ViewState<S, E> = state

    fun observe(): Observable<ViewState<S, E>> = stateSubject.hide()

    fun stop() {
        disposables.clear()
    }
}
