package com.compose.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.compose.fooddelivery.ui.screen.onboarding.OnboardingScreen
import com.compose.fooddelivery.ui.theme.FoodDeliveryTheme


const val ONBOARDING_PAGE_COUNT = 3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FoodDeliveryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { contentPadding ->

                    OnboardingScreen(
                        paddingValues = contentPadding,
                        onboardingFinished = {}
                    )
                }
            }
        }
    }
}