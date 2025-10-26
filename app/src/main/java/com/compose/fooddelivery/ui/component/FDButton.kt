package com.compose.fooddelivery.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BackButton(
    onBackClicked: () -> Unit
) {

    IconButton(
        onClick = onBackClicked,
        modifier = Modifier
            .padding(start = 24.dp, top = 48.dp)
            .size(40.dp)
            .background(
                Color.White,
                shape = CircleShape
            )
    ) {
        Icon(
            painterResource(FDIcons.back),
            contentDescription = "Back",
            tint = Color(0xFF111121)
        )
    }
}

@Composable
fun FDButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick = { onClick },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFE6C00)),
        shape = RoundedCornerShape((12.dp))
    ) {
        Text(text, color = Color.White, fontWeight = FontWeight.Bold)
    }
}
