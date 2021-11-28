package com.wultimaproject.ripple.viewmodel

import androidx.lifecycle.ViewModel
import com.wultimaproject.ripple.communication.state.publisher.RippleStateHandler
import com.wultimaproject.ripple.communication.state.publisher.RippleStatePublisher
import com.wultimaproject.ripple.communication.state.RippleState
import com.wultimaproject.ripple.communication.state.publisher.RippleConverter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

/**
 * RippleViewModel needs 2 starting references:
 * 1) Ref to the publisher, which is called default publisher
 * 2) Ref to the methods that handle states.
 * 3) Ref to the methods that handle lambdas within coroutines. These methods should pass a non suspended function to a suspended function inside coroutine.
 *
 * RippleViewModel has the main function to expose 2) to the presentation layer passing the operation to the working layer via 1)
 */
abstract class RippleViewModel : ViewModel(), RippleStateHandler {

    // get the default publisher
    val defaultPublisher = AndroidConfiguration().getDefaultPublisher()

    //handle states
    override fun getCurrentState()
    override fun publishState()

    //handle lambda to be executed in coroutines

    override fun rippleAction(suspend ()->Unit)
    override fun rippleActionWithError(suspend () -> Unit)
}

// publisher.
data class AndroidConfiguration(
    val capacity: Int = Channel.BUFFERED,
    val coroutineDispatcher : CoroutineDispatcher = Dispatchers.IO,
    val publisher = HandleStatePublishing() // same interface or row 30-31
){
    fun getDefaultPublisher() =
        when{
            publisher != null -> publisher
            else -> createDefaultPublisher
        }
}




