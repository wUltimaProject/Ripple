package com.wultimaproject.ripple.presentation.viewmodel

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.wultimaproject.ripple.presentation.state.ListState
import com.wultimaproject.ripple.presentation.state.ListState.*
import com.wultimaproject.ripple.viewmodel.RippleViewModel
import kotlinx.coroutines.flow.StateFlow

class ListViewModel : RippleViewModel<ListState>() {

    override val initialState: ListState
        get() = Empty()

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
        }
}

@Composable
fun <T> StateFlow<T>.returnMyValue(mValue: Class<T>) =
    mValue.cast(collectAsState().value)

