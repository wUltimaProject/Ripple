package com.wultimaproject.ripple.viewmodel

import androidx.lifecycle.ViewModel
import com.wultimaproject.ripple.communication.state.publisher.RippleStateHandler
import com.wultimaproject.ripple.communication.state.publisher.RippleStatePublisher
import com.wultimaproject.ripple.communication.state.RippleState

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

/**
 * Right now, RippleViewModel is just another layer between the actual viewmodel and the publisher which does the actual coroutine job.
 * It's important to keep RippleViewModel for future expansions, like :
 * 1 - management of coroutines with different scopes
 * 2 - dispatch of results on different channels
 * 3 - caching mechanism
 * 4 - etc
 */
abstract class RippleViewModel : ViewModel(), RippleStateHandler {
    private val defaultPublisher: RippleStateHandler = RippleStatePublisher()

    override fun setState(state: RippleState) = defaultPublisher.setState(state)
//    override suspend fun setState(block: () -> RippleState) = defaultPublisher.setState(block)
    override fun getState() = defaultPublisher.getState()
    override suspend fun getStateFromSuspended() = defaultPublisher.getStateFromSuspended()
//    override suspend fun deliverState(state: RippleState) = defaultPublisher.deliverState(state)
}
