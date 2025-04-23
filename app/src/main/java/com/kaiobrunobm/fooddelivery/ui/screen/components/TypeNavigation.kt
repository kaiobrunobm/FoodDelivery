package com.kaiobrunobm.fooddelivery.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kaiobrunobm.fooddelivery.ui.theme.AppTheme

@Composable
fun TypeNavigation(
    modifier: Modifier = Modifier,
    typeHeader: String,
    imageRes: Int,
    backgroundColor: Color,
) {

    Box(
        modifier
            .background(
                color = backgroundColor, shape = RoundedCornerShape(28.dp)
            )
            .clip(RoundedCornerShape(28.dp))
            .padding(
                horizontal = 8.dp,
            )
            .padding(top = 26.dp),
        contentAlignment = Alignment.TopCenter,

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
        ) {

            Text(
                text = typeHeader, style = AppTheme.typography.bodySmall
            )
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                modifier = Modifier
                    .offset(y = 8.dp, x = 16.dp)
                    .size(96.dp)
            )
        }
    }
}