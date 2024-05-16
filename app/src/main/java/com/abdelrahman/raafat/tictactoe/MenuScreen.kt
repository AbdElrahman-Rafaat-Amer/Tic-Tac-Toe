package com.abdelrahman.raafat.tictactoe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.tictactoe.ui.components.RoundedCardView


@Composable
fun MenuScreen(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic
        )

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            RoundedCardView(text = stringResource(id = R.string.computer)) {
                viewModel.playWithComputer()
            }
            Spacer(modifier = Modifier.height(30.dp))

            RoundedCardView(text = stringResource(id = R.string.friend)) {
                viewModel.playWithFriend()
            }
            Spacer(modifier = Modifier.height(30.dp))

            RoundedCardView(text = stringResource(id = R.string.online)) {
                viewModel.playOnline()
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(MainViewModel())
}
