package com.abdelrahman.raafat.tictactoe.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdelrahman.raafat.tictactoe.MainActivity
import com.abdelrahman.raafat.tictactoe.ui.theme.TicTacToeTheme

class SplashActivity : ComponentActivity() {

    private val onboardingViewModel by viewModels<OnboardingViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme {
                NavHostController(onboardingViewModel)
                if (onboardingViewModel.isOnboardingEnded) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}

@Composable
fun NavHostController(onboardingViewModel: OnboardingViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("SplashScreen") {
            SplashScreen(onboardingViewModel)
        }
        composable("OnboardingScreen") {
            OnboardingScreen(onboardingViewModel)
        }
    }

    if (onboardingViewModel.isSplashScreenEnded) {
        navController.clearBackStack("SplashScreen")
        navController.navigate("OnboardingScreen")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    TicTacToeTheme {
        SplashActivity()
    }
}