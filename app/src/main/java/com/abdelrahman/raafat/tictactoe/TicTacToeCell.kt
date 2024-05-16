package com.abdelrahman.raafat.tictactoe


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.tictactoe.ui.components.LineDemo

@Composable
fun TicTacToeCell(
    text: String, index: Int, isGameOVer: Boolean, onclick: () -> Unit
) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val itemHeight = (screenHeight / 2) / 3
    Column(
        modifier = Modifier
            .height(itemHeight)
            .clickable(text.isEmpty() && !isGameOVer) {
                onclick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = text,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 35.sp
                    ),
                    color = if (text == PLAYER_X) Color.Red else Color.Blue
                )
            }
            if ((index + 1) % 3 != 0) {
                LineDemo(true)
            }
        }


    }
    if (index > 2) {
        LineDemo(false)
    }
}