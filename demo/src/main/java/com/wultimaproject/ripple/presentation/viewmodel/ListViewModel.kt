package com.wultimaproject.ripple.presentation.viewmodel

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

import com.wultimaproject.ripple.presentation.state.ListState.*
import com.wultimaproject.ripple.viewmodel.RippleViewModel

class ListViewModel : RippleViewModel() {
    fun updateStatus() =
        when (getState()) {
            is Empty -> {
                deliverState(Loading())
            }
            is Loading -> {
                deliverState(Success())
            }
            is Success -> {
                deliverState(Empty())
            }
            else -> {
                deliverState(Empty())
            }
        }
}
