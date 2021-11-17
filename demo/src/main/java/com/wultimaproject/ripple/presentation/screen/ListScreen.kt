package com.wultimaproject.ripple.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import com.wultimaproject.ripple.communication.state.RippleState
import com.wultimaproject.ripple.presentation.theme.RippleTheme
import com.wultimaproject.ripple.presentation.viewmodel.ListViewModel

@Composable
fun ListScreen() {
    val viewModel: ListViewModel by lazy { ListViewModel() }
    ListMainTheme(viewModel = viewModel)
}

@Composable
fun ListMainTheme(
    viewModel: ListViewModel,
) = RippleTheme {
    Surface(color = MaterialTheme.colors.background) {
        RenderState(viewModel = viewModel)
    }
}

@Composable
fun RenderState(viewModel: ListViewModel,) {
//    val mState = viewModel.stateToObserve.collectAsState()
    val actualState = (RippleState.Loading)
//    val actualState = (mState.value)
    SetColumn(actualState.toString()) {
        viewModel.getNextState()
//        viewModel.updateStatus()
    }
}

@Composable
fun SetColumn(state: String?, onClick: (() -> Unit)? = null) {
    Column {
        state?.let { stateString ->
            Greeting(stateString)
            onClick?.let {
                SetButton(
                    stateString,
                    onClickListener = onClick
                )
            }
        } ?: run {
            Greeting("no state available")
            SetButton("retry") {
                onClick?.invoke()
            }
        }
    }
}

@Composable
fun SetButton(actualState: String, onClickListener: () -> Unit) {
    Button(
        onClick = onClickListener,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Red
        )
    ) {
        Text(text = actualState)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
