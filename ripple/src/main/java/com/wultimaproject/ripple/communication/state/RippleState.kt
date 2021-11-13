package com.wultimaproject.ripple.communication.state

/**
 * Created by Antonio Coppola on 06/11/2021.
 */
open class RippleState : RippleStateSerialized {

    object Empty : RippleState() {
        override fun toString() = "RippleState Empty has been issued."
    }
    object Loading : RippleState() {
        override fun toString() = "RippleState Loading has been issued."
    }

    object Success : RippleState() {
        override fun toString() = "RippleState Success has been issued."
    }

}
