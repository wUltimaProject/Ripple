package com.wultimaproject.ripple.presentation.viewmodel

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.wultimaproject.ripple.presentation.state.RenderEvent
import com.wultimaproject.ripple.presentation.state.RenderState
import com.wultimaproject.ripple.presentation.state.RenderState.*
import com.wultimaproject.ripple.viewmodel.RippleViewModel
import kotlinx.coroutines.flow.StateFlow

class StateReaderViewModel : RippleViewModel<RenderState, RenderEvent>() {

    override val initialState: RenderState
        get() = WakeUp()

    override val initialEvent: RenderEvent
        get() = RenderEvent.Empty()

    fun updateStatus() =
        when (getCurrentState()) {
            is WakeUp -> {
                transmitState(GoToPc())
            }
            is GoToPc -> {
                transmitState(WhatToDo())
            }
            is WhatToDo -> {
                transmitState(WakeUp())
            }
        }

    fun chooseYourSolution(solution: Solution){
        when(solution) {
            Solution.SOL1 -> transmitEvent(RenderEvent.Alcohol())
            Solution.SOL2 -> transmitEvent(RenderEvent.Drugs())
            Solution.SOL3 -> transmitEvent(RenderEvent.Missing())
        }
    }
}

enum class Solution{
    SOL1,
    SOL2,
    SOL3
}

@Composable
fun <T> StateFlow<T>.returnMyValue(mValue: Class<T>) =
    mValue.cast(collectAsState().value)

