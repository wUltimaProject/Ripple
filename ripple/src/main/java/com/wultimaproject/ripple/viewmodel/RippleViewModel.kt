package com.wultimaproject.ripple.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

abstract class RippleViewModel<T, S> : ViewModel() {
    abstract val initialState: T
    abstract val initialEvent: S
    val stateToObserve: MutableStateFlow<T> by lazy { MutableStateFlow(initialState) }
    val eventToObserve: MutableStateFlow<S> by lazy { MutableStateFlow(initialEvent) }

    fun transmitState(value: T) {
        viewModelScope.launch {
            stateToObserve.value = value
        }
    }

    fun transmitEvent(value: S) {
        viewModelScope.launch {
            eventToObserve.value = value
        }
    }

    fun getCurrentState() = stateToObserve.value
}
