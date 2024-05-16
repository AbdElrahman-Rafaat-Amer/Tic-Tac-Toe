package com.abdelrahman.raafat.tictactoe.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.tictactoe.R

@Composable
fun RoundedCardView(
    text: String,
    roundedCornerSize: Dp = 50.dp,
    widthFraction: Float = 0.7f,
    height: Dp = 60.dp,
    background: Color = Color.LightGray,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.Transparent,
    onCardClicked: () -> Unit
) {
    Card(
        onClick = { onCardClicked() },
        modifier = Modifier
            .fillMaxWidth(widthFraction)
            .height(height),
        border = BorderStroke(borderWidth, borderColor),
        shape = RoundedCornerShape(roundedCornerSize),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(background)
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RoundedCardViewPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        RoundedCardView(text = stringResource(id = R.string.computer)) {

        }
    }

}