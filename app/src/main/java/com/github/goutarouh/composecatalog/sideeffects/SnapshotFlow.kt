package com.github.goutarouh.composecatalog.sideeffects

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect

/**
 * State -> Flow
 */
@Composable
fun SnapshotFlow() {

    val lazyListState = rememberLazyListState()
    val context = LocalContext.current


    LaunchedEffect(key1 = lazyListState) {
        val firstVisible = snapshotFlow { lazyListState.firstVisibleItemIndex }
        firstVisible.collect {
            Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
        }
    }

    LazyColumn(
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
    ) {
        repeat(100) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                ) {
                    Box(
                        modifier = Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = it.toString())
                    }
                }
            }
        }
    }

}


@Preview
@Composable
fun PreviewSnapshotFlow() {
    SnapshotFlow()
}