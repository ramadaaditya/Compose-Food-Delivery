package com.compose.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.compose.fooddelivery.ui.screen.auth.LoginScreen
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