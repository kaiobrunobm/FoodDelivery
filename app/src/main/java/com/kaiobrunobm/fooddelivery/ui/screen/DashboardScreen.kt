package com.kaiobrunobm.fooddelivery.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kaiobrunobm.fooddelivery.R
import com.kaiobrunobm.fooddelivery.data.OffersData
import com.kaiobrunobm.fooddelivery.data.OffersState
import com.kaiobrunobm.fooddelivery.data.ProductState
import com.kaiobrunobm.fooddelivery.data.ProductsData
import com.kaiobrunobm.fooddelivery.data.TypesData
import com.kaiobrunobm.fooddelivery.data.TypesState
import com.kaiobrunobm.fooddelivery.ui.screen.components.NavigationBar
import com.kaiobrunobm.fooddelivery.ui.screen.components.OffersSection
import com.kaiobrunobm.fooddelivery.ui.screen.components.TypeNavigation
import com.kaiobrunobm.fooddelivery.ui.theme.AppTheme

@Composable
fun DashBoardScreen(
    modifier: Modifier = Modifier,
    onProductClick: () -> Unit,
) {
    val scrollableState = rememberScrollState()
    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
    ) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollableState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Content(
                onProductClick = onProductClick
            )
        }
        NavigationBar()
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    offers: List<OffersState> = OffersData,
    products: List<ProductState> = ProductsData,
    types: List<TypesState> = TypesData,
    onProductClick: () -> Unit,
) {

    Column(
        modifier.padding(
            horizontal = 24.dp, vertical = 42.dp
        )
    ) {

        GreetingUser()
        Spacer(
            modifier.height(26.dp)
        )
        SearchAndSort()
    }
    OffersSection(
        offers = offers
    )
    Spacer(
        Modifier.height(30.dp)
    )
    val scrollableState = rememberScrollState()
    Row(
        Modifier
            .horizontalScroll(scrollableState)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        types.forEach { item ->
            TypeNavigation(
                typeHeader = item.name,
                imageRes = item.imageRes,
                backgroundColor = item.backgroundColor,
            )
        }
    }
    Column(
        modifier.padding(
            horizontal = 24.dp, vertical = 42.dp
        )
    ) {
        Text(
            text = "Best Offers",
            style = AppTheme.typography.titleMedium,
            fontWeight = FontWeight.Normal,
            color = AppTheme.colors.onBackground
        )
        Spacer(
            Modifier.height(16.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
        ) {

            products.forEach { item ->
                ProductItem(
                    productName = item.name,
                    productImg = item.imageRes,
                    productDescription = item.description,
                    onProductClick = onProductClick
                )
                Spacer(
                    modifier = Modifier.height(18.dp)
                )
            }
        }
    }
}

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    productName: String,
    productDescription: String,
    productImg: Int,
    onProductClick: () -> Unit,
) {
    Surface(
        modifier = modifier.clickable(onClick = onProductClick),
        color = AppTheme.colors.searchBar,
        contentColor = AppTheme.colors.onBackground,
        shape = RoundedCornerShape(28.dp)
    ) {
        Box(
            modifier
                .fillMaxWidth()
                .background(
                    color = AppTheme.colors.searchBar, shape = RoundedCornerShape(28.dp)
                )
                .padding(
                    vertical = 14.dp, horizontal = 24.dp
                ), contentAlignment = Alignment.CenterStart

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Image(
                    painter = painterResource(productImg),
                    contentDescription = null,
                    Modifier.size(88.dp)
                )
                Column {
                    Text(
                        text = productName,
                        style = AppTheme.typography.titleMedium,
                        color = AppTheme.colors.onBackground,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = productDescription,
                        style = AppTheme.typography.titleSmall,
                        color = AppTheme.colors.onBackground,
                        fontWeight = FontWeight.Light,

                        )
                }
            }
        }
    }
}

@Composable
private fun GreetingUser(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .shadow(
                elevation = 10.dp, spotColor = Color.LightGray, shape = RoundedCornerShape(28.dp)
            )
            .background(
                shape = RoundedCornerShape(24.dp), color = AppTheme.colors.regularSurface
            )
            .fillMaxWidth()
            .padding(
                horizontal = 12.dp, vertical = 12.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    R.drawable.profileimage
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clickable(onClick = {})
            )
            Spacer(
                modifier = Modifier.width(12.dp)
            )
            Text(
                text = "Welcome back, Pin! How Hungry are you?",
                style = AppTheme.typography.body,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Start,
                color = AppTheme.colors.onRegularSurface
            )
        }
    }
}

@Composable
private fun SearchAndSort(modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier
                .background(
                    color = AppTheme.colors.searchBar, shape = RoundedCornerShape(16.dp)
                )
                .padding(
                    horizontal = 24.dp
                )
                .weight(
                    weight = 5f
                )
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = AppTheme.colors.onSearchBar
            )
            Text(
                text = "Search...", color = AppTheme.colors.onSearchBar
            )
        }
        Spacer(
            modifier = Modifier.width(12.dp)
        )
        Box(
            modifier = Modifier
                .background(
                    color = AppTheme.colors.secondarySurface, shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
                .weight(
                    weight = 1f
                ), contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(
                    R.drawable.filter
                ), contentDescription = null
            )
        }
    }
}