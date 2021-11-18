package com.wultimaproject.ripple.presentation.state

sealed class RenderState {
    data class WakeUp(val reason: String = "Mi sveglio!") : RenderState()
    data class GoToPc(val reason: String = "Lancio Slack!") : RenderState()
    data class WhatToDo(val reason: String = "Bug in produzione!") : RenderState()
}

sealed class RenderEvent {
    data class Empty(val solution: String = "None") : RenderEvent()
    data class Alcohol(val solution: String = "Mi ubriaco") : RenderEvent()
    data class Drugs(val solution: String = "Mi drogo") : RenderEvent()
    data class Missing(val solution: String = "Mi butto latitante") : RenderEvent()
}
