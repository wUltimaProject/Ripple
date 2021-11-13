package com.wultimaproject.ripple.communication.publisher

import com.wultimaproject.ripple.communication.state.RippleState
import io.uniflow.core.threading.onMain
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Created by Antonio Coppola on 06/11/2021.
 *
 * StatePublisher serves following purposes:
 *
 * - Keep tracks of the actual active state linked to the active viewmodel
 * - Manage the update of the flow channel to communicate state updates from viewmodel to presentation entity
 *
 */

// uniflow = LiveDataPublisher
open class StatePublisher(
    val actualState: RippleState,
) : StateHandler {

    private val _internalState = MutableStateFlow<RippleState>(RippleState.Empty)
    private val internalState: MutableStateFlow<RippleState> = _internalState

    override fun getState() = internalState.value

    override suspend fun deliverState(state: RippleState) {
        onMain(immediate = true) {
            internalState.value
        }
    }

    override fun setState(state: RippleState) {
        _internalState.value = state
    }

    override suspend fun getStateFromSuspended(): RippleState {
        TODO("Not yet implemented")
    }

    override suspend fun setState(block: () -> RippleState) {
        _internalState.value = block.invoke()
    }
}
