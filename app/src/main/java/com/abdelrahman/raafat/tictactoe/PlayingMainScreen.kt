package com.abdelrahman.raafat.tictactoe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.tictactoe.ui.theme.BlueCustom

@Composable
fun MainScreen(
    bord: List<String>,
    isGameOver: Boolean,
    isPlayerXTurn: Boolean,
    winner: String,
    playerXScore: Int,
    drawScore: Int,
    playerOScore: Int,
    onclick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        //Show the game states view
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 7.dp)
        ) {
            Text(
                text = "Player X: $playerXScore",
                fontSize = 20.sp
            )

            Text(
                text = "DRAW: $drawScore",
                fontSize = 20.sp
            )

            Text(
                text = "Player O: $playerOScore",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(70.dp))

        //Show the player turn view
        val playerTurnAlpha = if (isGameOver) 0f else 1f
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.alpha(playerTurnAlpha)
        ) {
            Text(
                text = when {
                    isPlayerXTurn -> "Player X Turn"
                    else -> "Player O Turn"
                },
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
            )
        }
        Spacer(modifier = Modifier.height(70.dp))

        //Show the board view
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            items(9) { index ->
                TicTacToeCell(bord[index], index, isGameOver) {
                    onclick(index)
                }
            }
        }

        //Show the play again view
        val commentsAlpha = if (isGameOver) 1f else 0f
        Spacer(
            modifier = Modifier
                .height(70.dp)
                .alpha(commentsAlpha)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .alpha(commentsAlpha)
        ) {
            Text(
                text = winner,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
            )
            Button(shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlueCustom,
                    contentColor = Color.White
                ),
                onClick = {
                    //Will reset board and play again with the same result
                }) {
                Text(text = "Play again")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        arrayListOf("X", "O", "X", "O", "O", "X", "O", "X", "O"),
        true, false, "DRAW",
        2, 3, 4
    ) {
    }
}