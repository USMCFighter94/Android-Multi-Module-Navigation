package com.brevitz.navigationcomponenttest.feature

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import kotlin.properties.Delegates

abstract class ViewModel<ViewState>(initialState: ViewState) {
    val disposables = CompositeDisposable()

    private val stateSubject = BehaviorSubject.createDefault(initialState)
    private var state: ViewState by Delegates.observable(initialState) { _, _, newState ->
        stateSubject.onNext(newState)
    }

    fun updateState(f: (ViewState) -> ViewState) {
        state = f(state)
    }

    fun currentState(): ViewState = state

    fun observe(): Observable<ViewState> = stateSubject.hide()

    fun stop() {
        disposables.clear()
    }
}
