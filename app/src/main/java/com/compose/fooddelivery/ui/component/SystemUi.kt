package com.compose.fooddelivery.ui.component

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun SetSystemBarsTheme(
    isLightStatusBars: Boolean,
    isLightNavigationBars: Boolean = isLightStatusBars,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        val window = (view.context as Activity).window
        val insetsController = WindowInsetsControllerCompat(window, view)
        DisposableEffect(isLightStatusBars, isLightNavigationBars) {
            val originalStatusBars = insetsController.isAppearanceLightStatusBars
            val originalNavBars = insetsController.isAppearanceLightNavigationBars
            insetsController.isAppearanceLightStatusBars = isLightStatusBars
            insetsController.isAppearanceLightNavigationBars = isLightNavigationBars
            onDispose {
                insetsController.isAppearanceLightStatusBars = originalStatusBars
                insetsController.isAppearanceLightNavigationBars = originalNavBars
            }
        }
    }
}