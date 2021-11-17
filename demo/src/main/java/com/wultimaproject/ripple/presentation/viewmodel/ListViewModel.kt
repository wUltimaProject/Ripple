package com.wultimaproject.ripple.presentation.viewmodel

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

import com.wultimaproject.ripple.communication.state.RippleIntent
import com.wultimaproject.ripple.communication.state.RippleState.*
import com.wultimaproject.ripple.viewmodel.RippleViewModel
import timber.log.Timber

class ListViewModel : RippleViewModel() {

    fun getNextState() {
        when (getState()) {
            Empty -> {
                saveState(Loading)
            }
            Loading -> { saveState(Success) }
            Success -> { saveState(Empty) }
        }

        manipulateState(
            RippleIntent(
                success = { getState() },
                error = { Timber.d("getStete with error")}
            )
        )
    }
}
