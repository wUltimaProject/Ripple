package com.wultimaproject.ripple.presentation.state

sealed class ListState {
    data class Empty(val reason: String = "Empty") : ListState()
    data class Loading(val reason: String = "Loading") : ListState()
    data class Success(val reason: String = "Success") : ListState()
}
