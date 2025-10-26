package com.compose.fooddelivery.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices.PIXEL_5
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.fooddelivery.R
import com.compose.fooddelivery.ui.component.BackButton
import com.compose.fooddelivery.ui.component.FDButton
import com.compose.fooddelivery.ui.component.FDIcons
import com.compose.fooddelivery.ui.component.SetSystemBarsTheme
import com.compose.fooddelivery.ui.theme.FoodDeliveryTheme


@Composable
fun ForgotPasswordScreen(
    onBackClicked: () -> Unit
) {
    SetSystemBarsTheme(
        isLightStatusBars = false,
        isLightNavigationBars = true
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = Color(0xFF111121),
                ),
        ) {
            Image(
                painterResource(R.drawable.bg_login_ast),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                alpha = 0.1f
            )
            BackButton(onBackClicked)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .padding(top = 120.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "Forgot Password",
                    style = TextStyle(
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    "Enter your email address for reset password",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp

                    )
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(2f)
                .offset(y = (-24).dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp
                    )
                )
                .padding(horizontal = 32.dp)
                .padding(top = 32.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("example@gmail.com") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            FDButton(
                onClick = {},
                text = "SEND CODE"
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = PIXEL_5)
@Composable
private fun LoginScreenPreview() {
    FoodDeliveryTheme {
        ForgotPasswordScreen(
            onBackClicked = {}
        )
    }
}