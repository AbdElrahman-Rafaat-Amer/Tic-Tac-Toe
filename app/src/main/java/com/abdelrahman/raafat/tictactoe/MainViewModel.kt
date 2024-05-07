package com.abdelrahman.raafat.tictactoe

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
        val winningCombinations = listOf(
            listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Rows
            listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columns
            listOf(0, 4, 8), listOf(2, 4, 6) // Diagonals
        )

        for (combination in winningCombinations) {
            val winner = checkWinning(board, *combination.toIntArray())
            if (winner != null) {
                isGameOver = true
                return
            }
        }

        if (board.all { it.isNotEmpty() }) {
            isGameOver = true
        }
    }

    private fun checkWinning(board: List<String>, vararg positions: Int): String? {
        val symbols = positions.map { board[it] }.toSet()
        return if (symbols.size == 1 && symbols.first().isNotEmpty()) symbols.first() else null
    }
}