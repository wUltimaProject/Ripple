package com.wultimaproject.ripple.presentation.state

import com.wultimaproject.ripple.viewmodel.MyState

sealed class ListState : MyState() {
    data class Empty(val reason: String = "empty") : ListState()
    data class Loading(val reason: String = "Loading") : ListState()
    data class Success(val reason: String = "Success") : ListState()
}
