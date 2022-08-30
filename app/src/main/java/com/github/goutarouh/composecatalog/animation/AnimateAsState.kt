package com.github.goutarouh.composecatalog.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimateAsState() {

    val enable = remember {
        mutableStateOf(false)
    }
    val alpha: Float by animateFloatAsState(
        targetValue = if (enable.value) 1f else 0f
    )


    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .graphicsLayer { this.alpha = alpha }
                .background(color = Color.Red)
        )
        Button(
            onClick = {
                enable.value = !enable.value
            }
        ) {
            Text(text = "toggle")
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
private fun PreviewMyAnimateAsState() {
    MyAnimateAsState()
}