package com.abdelrahman.raafat.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

const val PLAYER_X = "X" //player 1
const val PLAYER_O = "O" //player 2 or computer

class MainViewModel : ViewModel() {
    var startPlaying by mutableStateOf(false)
        private set

    var board by mutableStateOf(listOf("", "", "", "", "", "", "", "", ""))
        private set

    var isGameOver by mutableStateOf(false)
        private set
    var isPlayerXTurn by mutableStateOf(true)
        private set

    var winner by mutableStateOf("")
        private set

    var playerXScore by mutableIntStateOf(0)
        private set

    var drawScore by mutableIntStateOf(0)
        private set
    var playerOScore by mutableIntStateOf(0)
        private set


    fun play(move: Int) {
        if (isGameOver) return

        board = board.toMutableList().also {
            it[move] = if (isPlayerXTurn) {
                PLAYER_X
            } else {
                PLAYER_O
            }
        }
        isPlayerXTurn = !isPlayerXTurn
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
                this.winner = "Player $winner won"
                if (winner == PLAYER_X){
                    playerXScore++
                }else{
                    playerOScore++
                }
                return
            }
        }

        if (board.all { it.isNotEmpty() }) {
            isGameOver = true
            winner = "DRAW"
            drawScore++
        }
    }

    private fun checkWinning(board: List<String>, vararg positions: Int): String? {
        val symbols = positions.map { board[it] }.toSet()
        return if (symbols.size == 1 && symbols.first().isNotEmpty()) symbols.first() else null
    }

    fun playWithComputer() {
        //ToDO will be implemented later
    }

    fun playWithFriend() {
        startPlaying = true
    }

    fun playOnline() {
        //ToDO will be implemented later
    }
}