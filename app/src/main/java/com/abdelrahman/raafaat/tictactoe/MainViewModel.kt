package com.abdelrahman.raafaat.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var board by mutableStateOf(listOf("", "", "", "", "", "", "", "", ""))
        private set

    fun play(move: Int) {
        board = board.toMutableList().also {
            it[move] = "$move"
        }
    }


}