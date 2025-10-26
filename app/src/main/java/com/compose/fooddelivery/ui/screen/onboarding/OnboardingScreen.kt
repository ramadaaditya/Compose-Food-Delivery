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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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


private data class OnboardingPage(
    val imageRes: Int,
    val title: String,
    val description: String
)

private val onboardingPages = listOf(
    OnboardingPage(
        imageRes = R.drawable.placeholder,
        title = "All your favorites",
        description = "Get all your loved foods in one once place,\nyou just place the orer we do the rest"
    ),
    OnboardingPage(
        imageRes = R.drawable.placeholder,
        title = "Order from choosen chef",
        description = "Get all your loved foods in one once place, \n" +
                "you just place the orer we do the rest"
    ),
    OnboardingPage(
        imageRes = R.drawable.placeholder,
        title = "Fast delivery",
        description = "Get your food delivered in minutes\nright at your doorstep."
    )
)

//private const val ONBOARDING_PAGE_COUNT = 3

@Composable
fun OnboardingScreen(
    paddingValues: PaddingValues,
    onboardingFinished: () -> Unit
) {
    var currentPage by remember { mutableIntStateOf(0) }
    val totalPages = onboardingPages.size

    val currentPageData = onboardingPages[currentPage]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OnboardingPageCount(
                imageRes = currentPageData.imageRes,
                title = currentPageData.title,
                description = currentPageData.description
            )
            Spacer(modifier = Modifier.height(32.dp))
            PageIndicator(
                currentPage = currentPage,
                pageCount = totalPages,
                onDotClick = { index ->
                    currentPage = index
                })
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (currentPage < totalPages - 1) {
                        currentPage++
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

                val buttonText = if (currentPage < totalPages - 1) "NEXT" else "GET STARTED"
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
}


@Composable
fun OnboardingPageCount(
    imageRes: Int,
    title: String,
    description: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
