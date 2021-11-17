package com.wultimaproject.ripple.communication.state.publisher


/**
 * Created by Antonio Coppola on 06/11/2021.
 *
 * RippleStatePublisher serves following purposes:
 *
 * - Keep tracks of the actual active state linked to the active viewmodel
 * - Manage the update of the flow channel to communicate state updates from viewmodel to presentation entity
 *
 */

// uniflow = Dispatcher
// open class RippleStatePublisher(
//    private val reducer: RippleConverter
// ) : RippleStateHandler {
//
//    private val _internalState = MutableStateFlow<RippleState>(RippleState.Empty)
//    private val internalState: MutableStateFlow<RippleState> = _internalState
//
//    override fun getState() = internalState.value
//
// //    override suspend fun deliverState(state: RippleState) {
// //        onMain(immediate = true) {
// //            internalState.value
// //        }
// //    }
//
//    override suspend fun deliverState(state: RippleState) {
//        TODO("Not yet implemented")
//    }
//
//    override fun deliverState(block: () -> RippleState) {
//
//        // qui va la parte dell'action
// //        onMain(immediate = true){
// //            internalState.value = block.invoke()
// //        }
//    }
//
//    override fun setState(state: RippleState) {
//        _internalState.value = state
//    }
//
//    override suspend fun getStateFromSuspended(): RippleState {
//        TODO("Not yet implemented")
//    }
//
// //    override suspend fun setState(state: RippleState) {
// //        _internalState.value = block.invoke()
// //    }
//
//    @ObsoleteCoroutinesApi
//    fun dispatchToCoroutine(sendToCoroutine: ExecuteAction) {
//        reducer.enqueueAction(sendToCoroutine)
//    }
// }
//
// // uniflow = ActionReducer
// open class RippleConverter(
//    private val defaultPublisher: RippleStatePublisher,
//    private val coroutineScope: CoroutineScope,
//    private val defaultDispatcher: CoroutineDispatcher,
//    defaultCapacity: Int = Channel.BUFFERED,
//
// ) {
//    @ObsoleteCoroutinesApi
//    private val actor = coroutineScope.actor<ExecuteAction>(defaultDispatcher, capacity = defaultCapacity) {
//        for (action in channel) {
//            if (coroutineScope.isActive) {
//                withContext(defaultDispatcher) {
//                    reduceAction(action)
//                }
//            } else {
//                UniFlowLogger.debug("tag - $action cancelled")
//            }
//        }
//    }
//
//    @ObsoleteCoroutinesApi
//    @OptIn(ExperimentalCoroutinesApi::class)
//    open fun enqueueAction(action: ExecuteAction) {
//        val offered = if (!actor.isClosedForSend) actor.offer(action) else false
//        if (!offered) {
//            UniFlowLogger.logError("tag - $action couldn't be enqueued")
//        }
//    }
//
//    private suspend fun reduceAction(action: ExecuteAction) {
//        UniFlowLogger.debug("tag - reduce: $action")
//        val currentState: RippleState = defaultPublisher.getState()
//        try {
//            action.rippleSuccess(currentState)
//            UniFlowLogger.debug("tag - completed: $action")
//        } catch (e: Exception) {
//            UniFlowLogger.debug("tag - error: $action")
// //            action.onError(e, currentState)
//        }
//    }
// }
