package com.wultimaproject.ripple.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

abstract class RippleViewModel<T> : ViewModel() {
    abstract val initialState: T
    val stateToObserve: MutableStateFlow<T> by lazy { MutableStateFlow(initialState) }

    fun transmitState(value: T) {
        viewModelScope.launch {
            stateToObserve.value = value
        }
    }

    fun getCurrentState() = stateToObserve.value
}
