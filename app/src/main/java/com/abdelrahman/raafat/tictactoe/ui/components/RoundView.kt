package com.abdelrahman.raafat.tictactoe.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.tictactoe.ui.theme.TicTacToeTheme

@Composable
fun RoundView(
    modifier: Modifier = Modifier,
    size: Dp = 100.dp,
    backgroundColor: Color = Color.Transparent,
    shape: Shape = CircleShape
) {
    Box(
        modifier = modifier
            .size(size)
            .background(color = backgroundColor, shape = shape)
    )
}

@Preview(showBackground = true)
@Composable
fun RoundViewPreview() {
    TicTacToeTheme {
        RoundView(
            size = 15.dp,
            backgroundColor = Color.Blue
        )
    }
}