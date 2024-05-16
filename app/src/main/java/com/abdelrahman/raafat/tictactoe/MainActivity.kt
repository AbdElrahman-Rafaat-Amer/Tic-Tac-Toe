package com.abdelrahman.raafat.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abdelrahman.raafat.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    MainScreen(
//                        viewModel.board,
//                        viewModel.isGameOver,
//                        viewModel.isPlayerXTurn,
//                        viewModel.winner,
//                        viewModel.playerXScore,
//                        viewModel.drawScore,
//                        viewModel.playerOScore
//                    ) { index ->
//                        viewModel.play(index)
//                    }
                    MenuScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    TicTacToeTheme {
        MainScreen(
            arrayListOf("X", "O", "X", "O", "O", "X", "O", "X", "O"),
            true, false, "DRAW",
            2, 3, 4
        ) {

        }
    }
}