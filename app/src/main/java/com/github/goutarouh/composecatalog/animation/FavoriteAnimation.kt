package com.github.goutarouh.composecatalog.animation

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun FavoriteAnimationComposable() {

    val scope = rememberCoroutineScope()
    var alpha by remember { mutableStateOf(0f) }
    var scale by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .size(200.dp)
                .border(width = 1.dp, color = Color.Gray)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            scope.launch {
                                coroutineScope {
                                    launch {
                                        animate(
                                            initialValue = 0f,
                                            targetValue = 1f,
                                            animationSpec = tween(300)
                                        ) { value, _ ->
                                            alpha = value
                                        }
                                    }
                                    launch {
                                        animate(
                                            initialValue = 0f,
                                            targetValue = 0.5f,
                                            animationSpec = tween(300)
                                        ) { value, _ ->
                                            scale = value
                                        }
                                    }
                                }
                                coroutineScope {
                                    launch {
                                        animate(
                                            initialValue = 1f,
                                            targetValue = 0f,
                                            animationSpec = tween(300)
                                        ) { value, _ ->
                                            alpha = value
                                        }
                                    }
                                    launch {
                                        animate(
                                            initialValue = 0.5f,
                                            targetValue = 1f,
                                            animationSpec = tween(300)
                                        ) { value, _ ->
                                            scale = value
                                        }
                                    }
                                }
                            }
                        }
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .alpha(alpha)
                    .scale(scale)
                    .size(120.dp)
            )
        }
    }
}