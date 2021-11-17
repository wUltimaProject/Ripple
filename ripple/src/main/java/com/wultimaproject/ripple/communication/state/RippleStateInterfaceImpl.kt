package com.wultimaproject.ripple.communication.state

import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Created by Antonio Coppola on 14/11/2021.
 */
class RippleStateInterfaceImpl(private val dispatchInCoroutine: RippleDispatcher) : RippleStateInterface {

    private val _actualState = MutableStateFlow<RippleState>(RippleState.Empty)
    val actualState: MutableStateFlow<RippleState> = _actualState

    override fun saveState(state: RippleState) {
        _actualState.value = state
    }

    override fun getState() = actualState.value

    // this is an action
    override fun manipulateState(block: RippleIntent) {
        dispatchInCoroutine.enrouteIntent(block)
    }
}
