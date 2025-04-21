package com.kaiobrunobm.fooddelivery.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kaiobrunobm.fooddelivery.data.OrderData
import com.kaiobrunobm.fooddelivery.data.OrderState
import com.kaiobrunobm.fooddelivery.data.ProductDescriptionData
import com.kaiobrunobm.fooddelivery.data.ProductNutritionData
import com.kaiobrunobm.fooddelivery.data.ProductNutritionState
import com.kaiobrunobm.fooddelivery.data.ProductPreviewState
import com.kaiobrunobm.fooddelivery.ui.screen.components.FlavorSection
import com.kaiobrunobm.fooddelivery.ui.screen.components.OrderActionBar
import com.kaiobrunobm.fooddelivery.ui.screen.components.ProductDescriptionSection
import com.kaiobrunobm.fooddelivery.ui.screen.components.ProductNutritionSection
import com.kaiobrunobm.fooddelivery.ui.screen.components.ProductPreviewSection

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    orderState: OrderState = OrderData,
    productPreviewState: ProductPreviewState = ProductPreviewState(),
    productNutritionState: ProductNutritionState = ProductNutritionData,
    productDescription: String = ProductDescriptionData,
    onAddItemClicked: () -> Unit,
    onRemoveItemClicked: () -> Unit,
    onCheckoutClicked: () -> Unit,
    onAddCheddar: () -> Unit,
    onAddBacon: () -> Unit,
    onAddOnion: () -> Unit,
    amountCheddar: Int,
    amountBacon: Int,
    amountOnion: Int,
) {
    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
    ) {
        Content(
            productPreviewState = productPreviewState,
            productNutritionState = productNutritionState,
            productDescription = productDescription,
            onAddBacon = onAddBacon,
            onAddOnion = onAddOnion,
            onAddCheddar = onAddCheddar,
            amountCheddar = amountCheddar,
            amountBacon = amountBacon,
            amountOnion = amountOnion,

        )
        OrderActionBar(
            state = orderState,
            onAddItemClicked = onAddItemClicked,
            onRemoveItemClicked = onRemoveItemClicked,
            onCheckoutClicked = onCheckoutClicked,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(
                    horizontal = 18.dp, vertical = 8.dp
                )
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState,
    productNutritionState: ProductNutritionState,
    productDescription: String,
    onAddCheddar: () -> Unit,
    onAddBacon: () -> Unit,
    onAddOnion: () -> Unit,
    amountCheddar: Int,
    amountBacon: Int,
    amountOnion: Int,
) {
    val scrollableState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollableState)
    ) {
        ProductPreviewSection(
            state = productPreviewState
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        FlavorSection(
            modifier = Modifier.padding(horizontal = 18.dp),
            onAddCheddar = onAddCheddar,
            onAddOnion = onAddOnion,
            onAddBacon = onAddBacon,
            amountCheddar = amountCheddar,
            amountBacon = amountBacon,
            amountOnion = amountOnion,
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        ProductNutritionSection(
            Modifier.padding(horizontal = 18.dp), state = productNutritionState
        )
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        ProductDescriptionSection(
            productDescription = productDescription,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(horizontal = 18.dp)
                .padding(bottom = 128.dp)
        )
    }
}