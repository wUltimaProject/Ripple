package com.wultimaproject.ripple.presentation.state

sealed class RenderState {
    data class Empty(val reason: String = "Empty") : RenderState()
    data class Loading(val reason: String = "Loading") : RenderState()
    data class Success(val reason: String = "Success") : RenderState()
}

sealed class RenderEvent {
    data class Empty(val solution: String = "None") : RenderEvent()
    data class Alcohol(val solution: String = "Mi ubriaco") : RenderEvent()
    data class Drugs(val solution: String = "Mi drogo") : RenderEvent()
    data class Missing(val solution: String = "Mi butto latitante") : RenderEvent()
}
