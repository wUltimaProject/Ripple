package com.wultimaproject.ripple.communication.publisher

import com.wultimaproject.ripple.communication.state.RippleState

/**
 * Created by Antonio Coppola on 06/11/2021.
 *
 *  Contracts to manage operations on RippleState.
 *
 */

/**
 * deliverState = pass state from vm to observer
 * setState = state can be set directly or at the end of a block
 * getState = return actual active state
 * getStateFromSuspended = return state from a coroutine, if needed
 */
interface StateHandler {
    suspend fun deliverState(state: RippleState)
    fun setState(state: RippleState)
    suspend fun setState(state: () -> RippleState) = deliverState(state())
    fun getState(): RippleState
    suspend fun getStateFromSuspended(): RippleState
}
