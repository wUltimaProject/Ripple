package com.wultimaproject.ripple.communication.coroutinemanagement

import com.wultimaproject.ripple.communication.state.RippleState
import com.wultimaproject.ripple.communication.state.publisher.RippleStatePublisher
import kotlinx.coroutines.ObsoleteCoroutinesApi

/**
 * Created by Antonio Coppola on 13/11/2021.
 */

/**
 *
 *
 * RippleCoroutineManager serves as interface between UI thread and coroutine scope(s)
 *
 */
typealias ExecuteInCoroutine = suspend (RippleState) -> Unit // actionFunction
interface RippleCoroutineManager {
    val defaultDispatcher: RippleStatePublisher

    @ObsoleteCoroutinesApi
    fun openCoroutine(sendToCoroutine: ExecuteAction) = defaultDispatcher.dispatchToCoroutine(sendToCoroutine) // action-> dispatchAction(action)
}

data class ExecuteAction(
    val rippleSuccess: ExecuteInCoroutine
)
