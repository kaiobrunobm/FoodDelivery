package com.kaiobrunobm.fooddelivery.ui.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kaiobrunobm.fooddelivery.R
import com.kaiobrunobm.fooddelivery.ui.theme.AppTheme

@Composable
fun NavigationBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth()
            .padding(
                horizontal = 18.dp,
                vertical = 28.dp),
        shape = RoundedCornerShape(28.dp),
        color = AppTheme.colors.surface,
        contentColor = AppTheme.colors.onSurface,
        shadowElevation = 16.dp
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .height(60.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Column (
                Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.location
                    ),
                    contentDescription = null,
                    Modifier.size(32.dp)
                )
                Spacer(
                    Modifier.height(4.dp)
                )
                Text(
                    text = "Location",
                    style = AppTheme.typography.label,
                    color = AppTheme.colors.onBackground
                )
            }
            Column (
                Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.home
                    ),
                    contentDescription = null,
                    Modifier.size(32.dp)
                )
                Spacer(
                    Modifier.height(4.dp)
                )
                Text(
                    text = "Home",
                    style = AppTheme.typography.label,
                    color = AppTheme.colors.onBackground
                )
            }
            Column (
                Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.bag
                    ),
                    contentDescription = null,
                    Modifier.size(32.dp)
                )
                Spacer(
                    Modifier.height(4.dp)
                )
                Text(
                    text = "My Cart",
                    style = AppTheme.typography.label,
                    color = AppTheme.colors.onBackground
                )
            }
            Column (
                Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.user
                    ),
                    contentDescription = null,
                    Modifier.size(32.dp)
                )
                Spacer(
                    Modifier.height(4.dp)
                )
                Text(
                    text = "Me",
                    style = AppTheme.typography.label,
                    color = AppTheme.colors.onBackground
                )
            }
        }
    }
}