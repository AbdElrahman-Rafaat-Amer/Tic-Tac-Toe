package com.abdelrahman.raafaat.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var board by mutableStateOf(listOf("", "", "", "", "", "", "", "", ""))
        private set

    var isGameOver by mutableStateOf(false)
        private set

    private val PLAYER_X = "X" //player 1
    private val PLAYER_O = "O" //player 2 or computer
    private var isPlayerX = false


    fun play(move: Int) {
        if (isGameOver) return

        isPlayerX = !isPlayerX
        board = board.toMutableList().also {
            it[move] = if (isPlayerX) {
                PLAYER_X
            } else {
                PLAYER_O
            }
        }
        checkGameState()
    }

    private fun checkGameState() {
    }

}