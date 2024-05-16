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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdelrahman.raafat.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHostController(mainViewModel)
                }
            }
        }
    }
}

@Composable
fun NavHostController(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MenuScreen") {
        composable("MenuScreen") {
            MenuScreen(mainViewModel)
        }
        composable("MainScreen") {
            MainScreen(
                mainViewModel.board,
                mainViewModel.isGameOver,
                mainViewModel.isPlayerXTurn,
                mainViewModel.winner,
                mainViewModel.playerXScore,
                mainViewModel.drawScore,
                mainViewModel.playerOScore
            ) { index ->
                mainViewModel.play(index)
            }
        }
    }

    if (mainViewModel.startPlaying) {
        navController.navigate("MainScreen")
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