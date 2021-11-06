package com.wultimaproject.ripple.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * this has just one job: obscure the flow of the implemented viewmodel class.
 */
abstract class MyViewModel : ViewModel() {
    var stateToObserve = MutableStateFlow(MyState())

    fun transmitState(value: MyState) {
        viewModelScope.launch {
            stateToObserve.value = value
        }
    }

    fun getCurrentState() = stateToObserve.value
}

open class MyState
