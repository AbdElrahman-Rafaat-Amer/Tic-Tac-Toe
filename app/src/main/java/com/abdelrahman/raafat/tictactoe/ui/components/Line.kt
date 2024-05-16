package com.abdelrahman.raafat.tictactoe.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LineDemo(isVertical: Boolean, strokeWidth: Int = 6) {
    var endY = 0f
    var modifier = Modifier.fillMaxWidth()
    if (isVertical) {
        modifier = Modifier.fillMaxHeight()
    }
    Canvas(modifier = modifier) {
        if (isVertical) {
            endY = size.height
        }
        drawLine(
            start = Offset(x = 0f, y = 0F),
            end = Offset(x = size.width, y = endY),
            color = Color.DarkGray,
            strokeWidth = strokeWidth.dp.toPx(),
        )
    }
}