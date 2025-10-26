package com.compose.fooddelivery.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    onFacebookClick: () -> Unit,
    onTwitterClick: () -> Unit,
    onAppleClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(
            onClick = onFacebookClick,
            modifier = Modifier.size(60.dp)
        ) {
            Icon(
                painterResource(FDIcons.facebook),
                contentDescription = "Facebook",
                tint = Color.Unspecified
            )
        }
        IconButton(
            onClick = onTwitterClick,
            modifier = Modifier.size(60.dp)
        ) {
            Icon(
                painterResource(FDIcons.twitter),
                contentDescription = "Twitter",
                tint = Color.Unspecified
            )
        }
        IconButton(
            onClick = onAppleClick,
            modifier = Modifier.size(60.dp)
        ) {
            Icon(
                painterResource(FDIcons.icloud),
                contentDescription = "Apple",
                tint = Color.Unspecified
            )
        }
    }

}