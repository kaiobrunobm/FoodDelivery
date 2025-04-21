package com.kaiobrunobm.fooddelivery.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kaiobrunobm.fooddelivery.R
import com.kaiobrunobm.fooddelivery.data.ProductFlavorState
import com.kaiobrunobm.fooddelivery.ui.theme.AppTheme

@Composable
fun FlavorSection(
    modifier: Modifier = Modifier,
    onAddCheddar: () -> Unit,
    onAddBacon: () -> Unit,
    onAddOnion: () -> Unit,
    amountCheddar: Int,
    amountBacon: Int,
    amountOnion: Int,
) {
    Column(
        modifier = modifier
    ) {
        SectionHeader(
            title = "Add More Flavor"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            ProductFlavorItem(
                state = ProductFlavorState(
                    imageRes = R.drawable.cheeserealistic,
                    name = "Cheddar",
                    price = "$0.79",
                ),
                modifier = Modifier.weight(weight = 1f),
                onAddItem = onAddCheddar,
                amount = amountCheddar
            )
            ProductFlavorItem(
                state = ProductFlavorState(
                    imageRes = R.drawable.baon,
                    name = "Bacon",
                    price = "$0.59",
                ),
                onAddItem = onAddBacon,
                amount = amountBacon,
                modifier = Modifier.weight(weight = 1f)
            )
            ProductFlavorItem(
                state = ProductFlavorState(
                    imageRes = R.drawable.onionrealist,
                    name = "Onion",
                    price = "$0.29",
                ),
                amount = amountOnion,
                onAddItem = onAddOnion,
                modifier = Modifier.weight(weight = 1f)
            )

        }
    }
}

@Composable
private fun ProductFlavorItem(
    modifier: Modifier = Modifier, state: ProductFlavorState, onAddItem: () -> Unit, amount: Int
) {

    Box(
        modifier = modifier
            .shadow(
                elevation = 10.dp, spotColor = Color.LightGray, shape = RoundedCornerShape(28.dp)
            )
            .background(
                shape = RoundedCornerShape(28.dp), color = AppTheme.colors.regularSurface
            )
            .clickable(
                onClick = onAddItem
            )
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = 20.dp, horizontal = 8.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = state.imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = state.name,
                    style = AppTheme.typography.bodySmall,
                    color = AppTheme.colors.onRegularSurface
                )
                Text(
                    text = "+${state.price}",
                    style = AppTheme.typography.bodySmall,
                    color = AppTheme.colors.onRegularSurface
                )
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
                if (amount > 0) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "$amount x",
                            style = AppTheme.typography.label,
                            color = AppTheme.colors.onBackground
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionHeader(
    modifier: Modifier = Modifier, title: String
) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colors.onBackground
        )
    }
}