package com.compose.fooddelivery.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices.PIXEL_5
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.fooddelivery.R
import com.compose.fooddelivery.ui.component.PageIndicator
import com.compose.fooddelivery.ui.theme.FoodDeliveryTheme
import kotlinx.coroutines.launch

private const val ONBOARDING_PAGE_COUNT = 3

@Composable
fun OnboardingScreen(
    paddingValues: PaddingValues,
    onboardingFinished: () -> Unit
) {
    val pagerState = rememberPagerState { ONBOARDING_PAGE_COUNT }
    val scope = rememberCoroutineScope()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { pageIndex ->
            when (pageIndex) {
                0 -> OnboardingPageCount(
                    imageRes = R.drawable.placeholder,
                    title = "All your favorites",
                    description = "Get all your loved foods in one once place,\nyou just place the orer we do the rest"
                )

                1 -> OnboardingPageCount(
                    imageRes = R.drawable.placeholder,
                    title = "Order from choosen chef",
                    description = "Get all your loved foods in one once place, \n" +
                            "you just place the orer we do the rest"
                )

                2 -> OnboardingPageCount(
                    imageRes = R.drawable.placeholder,
                    title = "Fast delivery",
                    description = "Get your food delivered in minutes\nright at your doorstep."
                )
            }
        }

        PageIndicator(
            pagerState = pagerState,
            onDotClick = { index ->
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
            })
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (pagerState.currentPage < ONBOARDING_PAGE_COUNT - 1) {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                } else {
                    onboardingFinished()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF7622)
            )
        ) {
            val buttonText =
                if (pagerState.currentPage < ONBOARDING_PAGE_COUNT - 1) "NEXT" else "GET STARTED"
            Text(
                text = buttonText,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "SKIP",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            modifier = Modifier
                .clickable { onboardingFinished() }
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))

    }
}


@Composable
fun OnboardingPageCount(
    imageRes: Int,
    title: String,
    description: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = "placeholder",
            modifier = Modifier
                .height(292.dp)
                .width(240.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(
    showSystemUi = true,
    showBackground = true,
    device = PIXEL_5
)
@Composable
private fun OnboardingScreen1Prev() {
    FoodDeliveryTheme {
        Scaffold { paddingValues ->
            OnboardingScreen(
                paddingValues = paddingValues,
                onboardingFinished = {}
            )
        }
    }
}
