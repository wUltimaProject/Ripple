package com.wultimaproject.ripple.communication.state

/**
 * Created by Antonio Coppola on 14/11/2021.
 */

typealias RippleBlock = () -> Unit
typealias RippleBlockWithError = suspend (RippleState) -> Unit
data class RippleIntent(
    val success: RippleBlock,
    val error: RippleBlockWithError
)
