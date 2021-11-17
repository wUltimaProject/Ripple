package com.wultimaproject.ripple.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wultimaproject.ripple.communication.state.RippleDispatcher
import com.wultimaproject.ripple.communication.state.RippleIntent
import com.wultimaproject.ripple.communication.state.RippleState
import com.wultimaproject.ripple.communication.state.RippleStateInterfaceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ObsoleteCoroutinesApi

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
open class RippleViewModel : ViewModel() {
    val somethingToReturn  = 0

    private val intf: RippleStateInterfaceImpl by lazy {
        RippleStateInterfaceImpl(
            RippleDispatcher(viewModelScope, Dispatchers.Main)
        )
    }
    @ObsoleteCoroutinesApi
    fun getState(): RippleState =
        intf.getState()
    @ObsoleteCoroutinesApi
    fun saveState(state: RippleState) {
        intf.saveState(state)
    }
    @ObsoleteCoroutinesApi
    fun manipulateState(block: RippleIntent) {
        intf.manipulateState(block)
    }
}
