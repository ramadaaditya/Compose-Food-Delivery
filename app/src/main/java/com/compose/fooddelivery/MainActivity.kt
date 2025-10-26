package com.compose.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.compose.fooddelivery.ui.screen.login.LoginScreen
import com.compose.fooddelivery.ui.screen.onboarding.OnboardingScreen
import com.compose.fooddelivery.ui.theme.FoodDeliveryTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FoodDeliveryTheme {
                LoginScreen(
                )
//                Scaffold(modifier = Modifier.fillMaxSize()) { contentPadding ->

//                    OnboardingScreen(
//                        paddingValues = contentPadding,
//                        onboardingFinished = {}
//                    )
            }
//            }
        }
    }
}