package com.abdelrahman.raafat.tictactoe.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abdelrahman.raafat.tictactoe.MainActivity
import com.abdelrahman.raafat.tictactoe.ui.theme.TicTacToeTheme

class OnboardingActivity : ComponentActivity() {
    private val onboardingViewModel by viewModels<OnboardingViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme {
                OnboardingScreen(onboardingViewModel)

                if (onboardingViewModel.isOnboardingEnded) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    TicTacToeTheme {

    }
}