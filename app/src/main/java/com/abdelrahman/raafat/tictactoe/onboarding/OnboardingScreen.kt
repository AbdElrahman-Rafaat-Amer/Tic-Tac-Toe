package com.abdelrahman.raafat.tictactoe.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.tictactoe.R
import com.abdelrahman.raafat.tictactoe.ui.components.RoundView


@Composable
fun OnboardingScreen(
    onboardingViewModel: OnboardingViewModel
) {

    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(onboardingViewModel.getImage),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = onboardingViewModel.title,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = onboardingViewModel.description,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            TextButton(
                onClick = { onboardingViewModel.onBackClicked() },
                enabled = onboardingViewModel.isBackButtonEnabled,
                modifier = Modifier.alpha(onboardingViewModel.backButtonAlpha)
            ) {
                Text(
                    text = stringResource(id = R.string.back),
                    fontSize = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Row {
                RoundView(
                    size = 15.dp,
                    backgroundColor = onboardingViewModel.firstDotColor
                )
                RoundView(
                    size = 15.dp,
                    backgroundColor = onboardingViewModel.secondDotColor,
                    modifier = Modifier.padding(horizontal = 6.dp)
                )
                RoundView(
                    size = 15.dp,
                    backgroundColor = onboardingViewModel.thirdDotColor
                )
            }

            TextButton(onClick = { onboardingViewModel.onNextClicked() }) {
                Text(
                    text = stringResource(id = R.string.next),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }
        }
    }
}