package com.kaiobrunobm.fooddelivery.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.kaiobrunobm.fooddelivery.R
import com.kaiobrunobm.fooddelivery.data.ProductPreviewState
import com.kaiobrunobm.fooddelivery.ui.theme.AppTheme

@Composable
fun ProductPreviewSection(
    modifier: Modifier = Modifier, state: ProductPreviewState, onCloseButton: () -> Unit
) {
    Box(
        modifier = modifier.height(IntrinsicSize.Max)
    ) {
        ProductBackground(
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Content(
            state = state,
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 24.dp),
            onCloseButton = onCloseButton
        )
    }
}

@Composable
private fun ProductBackground(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = AppTheme.colors.secondarySurface, shape = RoundedCornerShape(
                    bottomStart = 32.dp, bottomEnd = 32.dp
                )
            )
    )
}

@Composable
private fun Content(
    modifier: Modifier = Modifier, state: ProductPreviewState, onCloseButton: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (actionBar, highlights, productImage) = createRefs()

        ActionBar(
            headline = "Mr. Cheezy",
            onCloseButton = onCloseButton,
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .constrainAs(actionBar) {
                    top.linkTo(parent.top)
                })


        Image(
            painter = painterResource(R.drawable.realistcburger),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(306.dp)
                .constrainAs(productImage) {
                    end.linkTo(parent.end)
                    top.linkTo(anchor = actionBar.bottom, margin = 20.dp)
                })

        ProductHighlights(
            highlights = state.highlight, modifier = Modifier.constrainAs(highlights) {
                start.linkTo(anchor = parent.start, margin = 19.dp)
                top.linkTo(productImage.top)
            })
    }
}

@Composable
fun ActionBar(
    modifier: Modifier = Modifier, headline: String, onCloseButton: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = headline,
            style = AppTheme.typography.headline,
            color = AppTheme.colors.onSecondarySurface
        )

        CloseButton(
            modifier.clickable(
                onClick = onCloseButton
            )
        )
    }
}

@Composable
private fun CloseButton(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.size(44.dp),
        shape = RoundedCornerShape(16.dp),
        color = AppTheme.colors.actionsSurface,
        contentColor = AppTheme.colors.secondarySurface
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {

            Icon(
                painter = painterResource(id = R.drawable.closeicon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
