package com.github.goutarouh.composecatalog.animation

import androidx.compose.animation.*
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MyAnimatedVisibility() {


    var editable by remember { mutableStateOf(true) }
    val density = LocalDensity.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        // Fade Animation
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Fade Animation")
            HorizontalCenteringRow {
                MyAnimatedContent(editable, fadeIn(), fadeOut())
                MyAnimatedContent(!editable, fadeIn(), fadeOut())
            }
        }

        // Scale Animation
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Scale Animation")
            HorizontalCenteringRow {
                MyAnimatedContent(editable, scaleIn(), scaleOut())
                MyAnimatedContent(!editable, scaleIn(), scaleOut())
            }
        }

        // Slide Animation
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Slide Animation")
            HorizontalCenteringRow {
                MyAnimatedContent(
                    editable,
                    slideIn {
                        with(density) { IntOffset(35.dp.roundToPx(), 35.dp.roundToPx()) }
                    },
                    slideOut {
                        with(density) { IntOffset(35.dp.roundToPx(), 35.dp.roundToPx()) }
                    }
                )
                MyAnimatedContent(
                    !editable,
                    slideIn {
                        with(density) { IntOffset(35.dp.roundToPx(), 35.dp.roundToPx()) }
                    },
                    slideOut {
                        with(density) { IntOffset(35.dp.roundToPx(), 35.dp.roundToPx()) }
                    }
                )
            }
        }

        // Expand and Shrink Animation
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Fade Animation")
            HorizontalCenteringRow {
                MyAnimatedContent(
                    editable,
                    expandIn(
                        expandFrom = Alignment.Center
                    ),
                    shrinkOut(
                        shrinkTowards = Alignment.Center
                    )
                )
                MyAnimatedContent(
                    !editable,
                    expandIn(
                        expandFrom = Alignment.Center
                    ),
                    shrinkOut(
                        shrinkTowards = Alignment.Center
                    )
                )
            }
        }
    }
}

@Composable
private fun MyAnimatedContent(
    editable: Boolean,
    enter: EnterTransition,
    exit: ExitTransition
) {

    Box(
        modifier = Modifier
            .size(70.dp)
            .border(width = 1.dp, color = Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = editable,
            modifier = Modifier.fillMaxSize(),
            enter = enter,
            exit = exit
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun HorizontalCenteringRow(content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        content = content
    )
}


@Preview(
    showBackground = true
)
@Composable
fun PreviewMyAnimatedVisibility() {
    MyAnimatedVisibility()
}