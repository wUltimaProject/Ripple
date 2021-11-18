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
import androidx.navigation.NavController
import com.wultimaproject.ripple.presentation.state.RenderEvent
import com.wultimaproject.ripple.presentation.state.RenderState.*
import com.wultimaproject.ripple.presentation.theme.UselessTheme
import com.wultimaproject.ripple.presentation.viewmodel.Solution
import com.wultimaproject.ripple.presentation.viewmodel.StateReaderViewModel
@Composable
fun StateReaderScreen() {
    val viewModel: StateReaderViewModel by lazy { StateReaderViewModel() }
//    InitResponseNavigation()
    StateReaderTheme(viewModel = viewModel)
//    classicNavController = navController
}

@Composable
fun StateReaderTheme(
    viewModel: StateReaderViewModel,
) = UselessTheme {
    Surface(color = MaterialTheme.colors.background) {
        RenderState(viewModel = viewModel)
    }
}

@Composable
fun RenderState(viewModel: StateReaderViewModel) {
    val actualState = viewModel.stateToObserve.collectAsState().value
    when (actualState) {
        is WakeUp ->
            SetStateOnScreen(viewModel, actualState.reason) {
                viewModel.updateStatus()
            }
        is GoToPc -> SetStateOnScreen(viewModel, actualState.reason) {
            viewModel.updateStatus()
        }
        is WhatToDo -> {
            SetStateOnScreen(viewModel, actualState.reason, true) {
                viewModel.updateStatus()
            }
        }
    }
}

@Composable
fun SetStateOnScreen(
    viewModel: StateReaderViewModel,
    stateName: String?,
    showNavigationBox: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    ConstraintLayout {
        val (button, boxNavigation, resultNavigation) = createRefs()
        val alignmentButton = Modifier.constrainAs(
            button
        ) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }
        val alignmentNavigationBox = Modifier.constrainAs(
            boxNavigation
        ) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        val alignmentResponse = Modifier.constrainAs(
            resultNavigation
        ) {
            bottom.linkTo(button.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        stateName?.let { name ->

            StateOfTheFragment(name)
            onClick?.let {
                SetButton(
                    modifier = alignmentButton,
                    onClickListener = onClick,
                )
            }
            if (showNavigationBox) {
                ShowEventBox(viewModel, alignmentNavigationBox)
                CaughtEvent(viewModel = viewModel, parentModifier = alignmentResponse)
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
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ShowEventBox(viewModel: StateReaderViewModel, parentModifier: Modifier) {
    val showEventModifier = parentModifier
        .height(180.dp)
        .fillMaxWidth()

    ConstraintLayout(
        modifier = showEventModifier
    ) {
        val (btn1, btn2, btn3) = createRefs()
        Button(
            modifier = Modifier.constrainAs(btn1) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(btn2.start)
            },
            onClick = {
                viewModel.chooseYourSolution(Solution.SOL1)
            }
        ) {
            Text("Busta n.1")
        }
        Button(
            modifier = Modifier.constrainAs(btn2) {
                top.linkTo(parent.top)
                start.linkTo(btn1.end)
                end.linkTo(btn3.start)
            },
            onClick = {
                viewModel.chooseYourSolution(Solution.SOL2)
            }
        ) {
            Text("Busta n.2")
        }
        Button(
            modifier = Modifier.constrainAs(btn3) {
                top.linkTo(parent.top)
                start.linkTo(btn2.end)
                end.linkTo(parent.end)
            },
            onClick = {
                viewModel.chooseYourSolution(Solution.SOL3)
            }
        ) {
            Text("Busta n.3")
        }
    }
}

@Composable
fun CaughtEvent(viewModel: StateReaderViewModel, parentModifier: Modifier) {
    ConstraintLayout(
        modifier = parentModifier
            .height(180.dp)
            .fillMaxWidth()
    ) {

        val actualEvent = viewModel.eventToObserve.collectAsState().value
        when (actualEvent) {
            is RenderEvent.Alcohol -> ConstraintLayout(
                modifier = parentModifier
            ) {
                val (textSolution) = createRefs()
                Text(actualEvent.solution)
            }

            is RenderEvent.Drugs -> ConstraintLayout(
                modifier = parentModifier
            ) {
                val (textSolution) = createRefs()
                Text(
                    actualEvent.solution,
                    modifier = Modifier.constrainAs(textSolution) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                )
            }
            is RenderEvent.Missing -> ConstraintLayout(
                modifier = parentModifier
            ) {
                val (textSolution) = createRefs()
                Text(
                    actualEvent.solution,
                    modifier = Modifier.constrainAs(textSolution) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                )
            }
            else -> {}
        }
    }
}

@Composable
fun Result1() {
    Row(Modifier.background(Color.Green)) {
        Text("Mi ubriaco", Modifier.background(Color.Black))
    }
}

@Composable
fun Result2() {
    Row(Modifier.background(Color.Yellow)) {
        Text("Mi drogo", Modifier.background(Color.Black))
    }
}

@Composable
fun Result3() {
    Row(Modifier.background(Color.Magenta)) {
        Text("Mi butto latitante", Modifier.background(Color.Black))
    }
}
