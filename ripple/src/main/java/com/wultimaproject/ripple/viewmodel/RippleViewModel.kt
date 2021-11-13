package com.wultimaproject.ripple.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

abstract class RippleViewModel : ViewModel() {
    var stateToObserve = MutableStateFlow(MyState())

    fun transmitState(value: MyState) {
        viewModelScope.launch {
            stateToObserve.value = value
        }
    }

    fun getCurrentState() = stateToObserve.value
}

open class MyState
