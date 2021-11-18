package com.wultimaproject.ripple.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.wultimaproject.ripple.presentation.state.ListState.*
import com.wultimaproject.ripple.presentation.theme.UselessTheme
import com.wultimaproject.ripple.presentation.viewmodel.ListViewModel

@Composable
fun StateReaderScreen() {
    val viewModel: ListViewModel by lazy { ListViewModel() }
    StateReaderTheme(viewModel = viewModel)
}

@Composable
fun StateReaderTheme(
    viewModel: ListViewModel,
) = UselessTheme {
    Surface(color = MaterialTheme.colors.background) {
        RenderState(viewModel = viewModel)
    }
}

@Composable
fun RenderState(viewModel: ListViewModel) {
    val actualState = viewModel.stateToObserve.collectAsState().value
//    val secondState = viewModel.stateToObserve.returnMyValue(mValue = ListState::class.java)
    when (actualState) {
        is Empty -> actualState.reason
        is Loading -> actualState.reason
        is Success -> actualState.reason
    }.also {
        SetColumn(it) {
            viewModel.updateStatus()
        }
    }
}

@Composable
fun SetColumn(stateName: String?, onClick: (() -> Unit)? = null) {
    ConstraintLayout(

        modifier = Modifier
            .background(Color.Green)
    ) {
        val (button) = createRefs()
        val alignmentButton = Modifier.constrainAs(
            button
        ) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }

        stateName?.let { name ->
            StateOfTheFragment(name)
            onClick?.let {
                SetButton(
                    modifier = alignmentButton ,
                    onClickListener = onClick,
                )
            }
        } ?: run {
            StateOfTheFragment("no state available")
            SetButton(
                alignmentButton
            ) {
                onClick?.invoke()
            }
        }
    }
}

@Composable
fun SetButton(modifier: Modifier, onClickListener: () -> Unit) {
    Button(
        onClick = onClickListener,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Red
        ),
        modifier = modifier
            .size(width = 120.dp, height = 80.dp)
    ) {
        Text(text = "Change State")
    }
}

@Composable
fun StateOfTheFragment(name: String) {
    Text(
        text = "State is: $name!",
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow),
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}
