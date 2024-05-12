package com.abdelrahman.raafat.tictactoe.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.abdelrahman.raafat.tictactoe.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SplashScreen(onAnimationEnded : () -> Unit) {
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

    if (preloaderLottieComposition != null) {
        LaunchedEffect(true) {
            this.launch {
                delay(preloaderLottieComposition!!.duration.toLong())
                onAnimationEnded()
            }
        }
    } else {
        if (progress == 1.0f) {
            onAnimationEnded()
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen{

    }
}
