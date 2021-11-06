package com.wultimaproject.ripple.presentation.viewmodel

import com.wultimaproject.ripple.presentation.state.ListState
import com.wultimaproject.ripple.presentation.state.ListState.*
import com.wultimaproject.ripple.viewmodel.MyViewModel


class ListViewModel : MyViewModel() {
    fun updateStatus() =
        when (getCurrentState()) {
            is Empty -> {
                transmitState(Loading())
            }
            is Loading -> {
                transmitState(Success())
            }
            is Success -> {
                transmitState(Empty())
            }
            else -> {
                transmitState(Empty())
            }
        }
}
