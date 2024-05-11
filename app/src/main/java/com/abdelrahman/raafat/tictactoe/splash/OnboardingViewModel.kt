package com.abdelrahman.raafat.tictactoe.splash

import android.app.Application
import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.abdelrahman.raafat.tictactoe.R

class OnboardingViewModel(private val application: Application) : AndroidViewModel(application) {

    var currentScreenIndex by mutableIntStateOf(0)
        private set

    private val imagesList =
        listOf(R.drawable.ic_onboarding_1, R.drawable.ic_onboarding_2, R.drawable.ic_onboarding_3)

    @DrawableRes
    val getImage: Int = imagesList[currentScreenIndex]

    val title: String
        get() {
            return when (currentScreenIndex) {
                0 -> application.getString(R.string.welcome)
                1 -> application.getString(R.string.compete)
                else -> application.getString(R.string.scoreboard)
            }
        }

    val description: String
        get() {
            return when (currentScreenIndex) {
                0 -> application.getString(R.string.welcome_description)
                1 -> application.getString(R.string.compete_description)
                else -> application.getString(R.string.scoreboard_description)
            }
        }

    fun showNextScreen() {
        currentScreenIndex++
    }

    fun onBackClicked() {
    }

    fun onNextClicked() {

    }
}