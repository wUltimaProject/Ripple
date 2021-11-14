package com.wultimaproject.ripple.communication.state.publisher

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

// DataPublisher
interface RippleStateHandler {
//    suspend fun deliverState(state: RippleState)
//    fun deliverState(block: () -> RippleState)
    fun setState(state: RippleState)
//    suspend fun setState(block: () -> RippleState) = deliverState(block())
    fun getState(): RippleState
    suspend fun getStateFromSuspended(): RippleState
}
