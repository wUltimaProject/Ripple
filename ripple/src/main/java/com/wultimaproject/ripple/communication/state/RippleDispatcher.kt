package com.wultimaproject.ripple.communication.state

import io.uniflow.core.logger.UniFlowLogger
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.channels.actor

/**
 * Created by Antonio Coppola on 14/11/2021.
 */
class RippleDispatcher(private val coroutineScope: CoroutineScope, private val coroutineDispatcher: CoroutineDispatcher) {
    @ObsoleteCoroutinesApi
    fun enrouteIntent(block: RippleIntent) {
        coroutineScope.actor<RippleIntent>(Dispatchers.Main, capacity = BUFFERED) {
            for (action in channel) {
                if (coroutineScope.isActive) {
                    withContext(coroutineDispatcher) {
                        block
                    }
                } else {
                    UniFlowLogger.debug("tag - $action cancelled")
                }
            }
        }
    }
}
