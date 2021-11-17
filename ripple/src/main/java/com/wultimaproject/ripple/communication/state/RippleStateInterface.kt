package com.wultimaproject.ripple.communication.state


/**
 * Created by Antonio Coppola on 14/11/2021.
 *
 *
 *
 *
 * Interface to expose state method to the viewmodel
 *
 * State methods are:
 * 1) save state
 * 2) get state
 * 3) manipulate state -> (action)
 */
interface RippleStateInterface {
    fun saveState(state: RippleState)
    fun getState(): RippleState
    fun manipulateState(block: RippleIntent)
}
