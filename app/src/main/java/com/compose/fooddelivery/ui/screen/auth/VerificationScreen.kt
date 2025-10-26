package com.compose.fooddelivery.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.fooddelivery.R
import com.compose.fooddelivery.ui.component.BackButton
import com.compose.fooddelivery.ui.component.FDButton
import com.compose.fooddelivery.ui.component.SetSystemBarsTheme
import com.compose.fooddelivery.ui.theme.FoodDeliveryTheme


@Composable
fun VerificationScreen(
    onBackClicked: () -> Unit,
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
                    "Verification",
                    style = TextStyle(
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    "We have sent a code to your email",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp

                    )
                )
                Text(
                    "example@gmail.com",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold

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
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("CODE")
                Text("Resend in 50Sec")

            }
            Spacer(Modifier.height(16.dp))
            OtpTextField(
                onOtpChange = {},
                otpValue = "",
                otpLength = 4
            )
            Spacer(Modifier.height(24.dp))
            FDButton(
                onClick = {},
                text = "SEND CODE"
            )
        }
    }
}


@Composable
fun OtpTextField(
    otpValue: String,
    onOtpChange: (String) -> Unit,
    otpLength: Int
) {
    BasicTextField(
        value = otpValue,
        onValueChange = onOtpChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        ),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {

                (0 until otpLength).forEach { index ->
                    val digit = otpValue.getOrNull(index)?.toString()
                    val hasFocus = index == otpValue.length

                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .background(
                                color = Color(0xFFF4F4F4),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = if (hasFocus) Color(0xFFFE6C00) else Color.Transparent,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (digit != null) {
                            Text(
                                text = digit,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    if (index < otpLength - 1) {
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun VerificationPreview() {
    FoodDeliveryTheme {
        VerificationScreen(onBackClicked = {})
    }
}