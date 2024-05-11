package com.abdelrahman.raafat.tictactoe.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.abdelrahman.raafat.tictactoe.R
import com.abdelrahman.raafat.tictactoe.ui.theme.TicTacToeTheme
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun SplashScreen(navigateToNextScreen: () -> Unit) {
    val preloaderLottieCompositionResult = rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.splash_icon
        )
    )

    val preloaderLottieComposition by preloaderLottieCompositionResult
    val progress by animateLottieCompositionAsState(preloaderLottieComposition)

    LottieAnimation(
        composition = preloaderLottieComposition
    )

    if (progress == 1.0f) {
        navigateToNextScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    TicTacToeTheme {
        SplashScreen() {

        }
    }
}
