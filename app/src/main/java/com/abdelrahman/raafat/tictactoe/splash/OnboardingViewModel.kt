package com.abdelrahman.raafat.tictactoe.splash

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.abdelrahman.raafat.tictactoe.R
import com.abdelrahman.raafat.tictactoe.ui.theme.DodgerBlue
import com.abdelrahman.raafat.tictactoe.ui.theme.NaturalGray

const val TAG = "OnboardingViewModel"

class OnboardingViewModel(private val application: Application) : AndroidViewModel(application) {

    private val screenNumbers = 3
    var isSplashScreenEnded by mutableStateOf(false)
        private set

    var isOnboardingEnded by mutableStateOf(false)
        private set

    var isBackButtonEnabled by mutableStateOf(false)
        private set

    private var currentScreenIndex = 0

    private val imagesList =
        listOf(R.drawable.ic_onboarding_1, R.drawable.ic_onboarding_2, R.drawable.ic_onboarding_3)

    var getImage by mutableIntStateOf(imagesList[0])
        private set

    private val initialColor = DodgerBlue
    var firstDotColor by mutableStateOf(initialColor)
        private set

    var secondDotColor by mutableStateOf(initialColor)
        private set

    var thirdDotColor by mutableStateOf(initialColor)
        private set

    var backButtonAlpha by mutableFloatStateOf(0f)
        private set

    var title by mutableStateOf("")
        private set

    var description by mutableStateOf("")
        private set


    private fun updateUIElements() {
        title = when (currentScreenIndex) {
            0 -> application.getString(R.string.welcome)
            1 -> application.getString(R.string.compete)
            else -> application.getString(R.string.scoreboard)
        }
        description = when (currentScreenIndex) {
            0 -> application.getString(R.string.welcome_description)
            1 -> application.getString(R.string.compete_description)
            else -> application.getString(R.string.scoreboard_description)
        }

        getImage = imagesList[currentScreenIndex]

        firstDotColor = if (currentScreenIndex == 0) DodgerBlue else NaturalGray

        secondDotColor = if (currentScreenIndex == 1) DodgerBlue else NaturalGray

        thirdDotColor = if (currentScreenIndex == 2) DodgerBlue else NaturalGray

        backButtonAlpha = if (currentScreenIndex == 0) 0f else 1f
    }

    fun onBackClicked() {
        currentScreenIndex--
        isBackButtonEnabled = currentScreenIndex != 0
        updateUIElements()
    }

    fun onNextClicked() {
        isBackButtonEnabled = true
        currentScreenIndex++
        if (currentScreenIndex < screenNumbers) {
            updateUIElements()
        } else {
            isOnboardingEnded = true
        }

    }

    fun showOnBoardingScreens() {
        updateUIElements()
        isSplashScreenEnded = true
    }
}