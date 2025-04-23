package com.kaiobrunobm.fooddelivery.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kaiobrunobm.fooddelivery.data.OffersState
import com.kaiobrunobm.fooddelivery.data.OffersType
import com.kaiobrunobm.fooddelivery.ui.theme.AppTheme

@Composable
fun OffersSection(modifier: Modifier = Modifier, offers: List<OffersState>) {
    val scrollableState = rememberScrollState()
    Column(
        modifier.fillMaxWidth()
    ) {
        Text(
            text = "Today’s Menu",
            color = AppTheme.colors.onBackground,
            style = AppTheme.typography.headline,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(
            Modifier.height(16.dp)
        )
        Row(
            modifier = Modifier
                .horizontalScroll(scrollableState)
                .padding(
                    start = 12.dp
                )
        ) {
            offers.forEach { item ->
                OffersItem(
                    data = item,
                    color = OffersDefault.colors(type = item.type)
                )
                Spacer(
                    modifier = Modifier.width(8.dp)
                )
            }
        }
    }

}

@Composable
private fun OffersItem(modifier: Modifier = Modifier, data: OffersState, color: OffersColor = OffersDefault.defaultColors) {
    Box(
        modifier
            .fillMaxWidth()
            .background(
                color = color.containerColor, shape = RoundedCornerShape(28.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(28.dp))
                .background( color = color.containerColor)
                .align(Alignment.CenterStart)

        ) {
            Column(
                modifier = Modifier
                    .padding(
                        start = 20.dp, top = 30.dp, bottom = 30.dp, end = 120.dp
                    )
                    .align(Alignment.CenterStart)
            ) {

                Text(
                    text = data.title,
                    style = AppTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.onHightlightSurface
                )
                Text(
                    text = data.subtitle,
                    style = AppTheme.typography.titleSmall,
                    fontWeight = FontWeight.Light,
                    color = AppTheme.colors.onHightlightSurface
                )
            }
        }
        Image(
            painter = painterResource(data.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(140.dp)
                .align(Alignment.TopEnd)
                .offset(x = 12.dp, y = (-30).dp)
        )
    }
}

private object OffersDefault {
    val defaultColors = OffersColor(
        contentColor = Color.Unspecified, containerColor = Color.Unspecified
    )

    @Composable
    fun colors(
        type: OffersType
    ): OffersColor = when (type) {
        OffersType.PRIMARY -> OffersColor(
            containerColor = AppTheme.colors.hightlightSurface,
            contentColor = AppTheme.colors.onHightlightSurface
        )
        OffersType.SECONDARY -> OffersColor(
            containerColor = AppTheme.colors.secondaryBackground,
            contentColor = AppTheme.colors.onHightlightSurface
        )
    }
}

@Immutable
private data class OffersColor(
    val contentColor: Color, val containerColor: Color
)