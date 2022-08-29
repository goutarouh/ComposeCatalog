package com.github.goutarouh.composecatalog.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun IntrinsicRow(
    text1: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Divider(
            color = Color.Red,
            modifier = Modifier
                .fillMaxHeight()
                .width(3.dp)
        )
        Text(
            modifier = Modifier
                .padding(start = 4.dp),
            text = text1
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewTowTexts() {
    IntrinsicRow(text1 = "My Compose Catalog\nMy Compose Catalog")
}