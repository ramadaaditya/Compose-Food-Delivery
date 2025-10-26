package com.compose.fooddelivery.ui.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    onDotClick: (Int) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(pagerState.pageCount) { index ->
            val isSelected = (index == pagerState.currentPage)
            val size =
                animateDpAsState(targetValue = if (isSelected) 10.dp else 8.dp, label = "dot size")
            val color = if (isSelected) Color(0xFFFF7622) else Color.LightGray

            Box(
                modifier = Modifier
                    .size(size.value)
                    .clip(CircleShape)
                    .background(color)
                    .clickable { onDotClick(index) }
            )
        }
    }
}