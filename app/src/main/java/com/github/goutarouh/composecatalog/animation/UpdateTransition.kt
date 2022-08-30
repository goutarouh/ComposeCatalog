package com.github.goutarouh.composecatalog.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private enum class BoxState{
    Small, Large
}

@Composable
fun TwoAnimation() {

    var boxState by remember { mutableStateOf(BoxState.Small) }
    val transition = updateTransition(
        targetState = boxState,
        label = "Box transition",
    )

    val color by transition.animateColor(label = "Color") { state ->
        when (state) {
            BoxState.Small -> Color.Blue
            BoxState.Large -> Color.Red
        }
    }
    val size by transition.animateDp(label = "Size") { state ->
        when (state) {
            BoxState.Small -> 32.dp
            BoxState.Large -> 128.dp
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        Button(onClick = {
            boxState = if (boxState == BoxState.Large) {
                BoxState.Small
            } else {
                BoxState.Large
            }
        }) {
            Text(text = "Toggle")
        }
        Box(modifier = Modifier
            .size(size)
            .background(color))
    }


}

@Preview(
    showBackground = true
)
@Composable
fun PreviewTwoAnimation() {
    TwoAnimation()
}
