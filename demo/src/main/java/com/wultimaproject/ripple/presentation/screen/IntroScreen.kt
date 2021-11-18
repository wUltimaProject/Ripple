package com.wultimaproject.ripple.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// @Composable
// fun IntroScreen(navigator: NavHostController) {
//    ConstraintLayout {
//        val (button) = createRefs()
//        TextButton(
//            onClick = {
//                navigator.navigate("list")
//            },
//            modifier = Modifier.constrainAs(button) {
//                top.linkTo(parent.top, margin = 16.dp)
//                start.linkTo(parent.start, margin = 16.dp)
//            }
//        ) {
//            Text("Init")
//        }
//    }
// }

@Composable
fun IntroScreen(onClick: () -> Unit) {
    Box {
        Button(
            modifier =
            Modifier
                .size(width = 200.dp, height = 200.dp)
                .align(alignment = Alignment.Center)
                .background(Color.Blue),
            onClick = onClick
        ) {
            Text("Init")
        }
    }
}
