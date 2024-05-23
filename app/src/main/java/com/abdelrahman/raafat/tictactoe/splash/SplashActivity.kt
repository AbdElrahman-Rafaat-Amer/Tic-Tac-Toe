package com.abdelrahman.raafat.tictactoe.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abdelrahman.raafat.tictactoe.MainActivity
import com.abdelrahman.raafat.tictactoe.PreferencesManager
import com.abdelrahman.raafat.tictactoe.onboarding.OnboardingActivity
import com.abdelrahman.raafat.tictactoe.ui.theme.TicTacToeTheme

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme {
                SplashScreen {
                    goNextScreen()
                }
            }
        }
    }

    private fun goNextScreen() {
        val willShowOnboarding =
            PreferencesManager.getBoolean(application.applicationContext, "SHOW_ONBOARDING", true)
        if (willShowOnboarding){
            startActivity(Intent(this, OnboardingActivity::class.java))
        }else{
            startActivity(Intent(this, MainActivity::class.java))
        }

        finish()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    TicTacToeTheme {
        SplashActivity()
    }
}