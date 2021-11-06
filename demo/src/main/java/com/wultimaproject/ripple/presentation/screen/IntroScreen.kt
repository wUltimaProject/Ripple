package com.wultimaproject.ripple.presentation.screen

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController

@Composable
fun IntroScreen(navigator: NavHostController) {
    ConstraintLayout {
        val (button) = createRefs()
        TextButton(
            onClick = {
                navigator.navigate("list")
            },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        ) {
            Text("Init")
        }
    }
}

@Composable
fun IntroScreen(onClick: () -> Unit) {
    ConstraintLayout {
        val (button) = createRefs()
        TextButton(
            onClick = onClick,
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        ) {
            Text("Init")
        }
    }
}
