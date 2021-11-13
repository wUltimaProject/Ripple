package com.wultimaproject.ripple.presentation.viewmodel

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

import com.wultimaproject.ripple.presentation.state.ListState.*
import com.wultimaproject.ripple.viewmodel.RippleViewModel

class ListViewModel : RippleViewModel() {
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
