package com.kaiobrunobm.fooddelivery.activities


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kaiobrunobm.fooddelivery.data.OrderState
import com.kaiobrunobm.fooddelivery.ui.screen.ProductDetailsScreen
import com.kaiobrunobm.fooddelivery.ui.theme.AppTheme
import java.text.DecimalFormat

private const val PRODUCT_PRICE_PER_UNIT = 5.25
private const val CHEDDAR_PRICE_PER_UNIT = 0.79
private const val BACON_PRICE_PER_UNIT = 0.59
private const val ONION_PRICE_PER_UNIT = 0.29
private const val PRODUCT_CURRENCY = "$"


class BurgerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                var amount by remember {
                    mutableIntStateOf(1)
                }
                var amountCheddar by remember {
                    mutableIntStateOf(0)
                }
                var amountOnion by remember {
                    mutableIntStateOf(0)
                }
                var amountBacon by remember {
                    mutableIntStateOf(0)
                }
                val extraFlavorCheddarPrice by remember {
                    derivedStateOf { amountCheddar * CHEDDAR_PRICE_PER_UNIT }
                }
                val extraFlavorBaconPrice by remember {
                    derivedStateOf { amountBacon * BACON_PRICE_PER_UNIT }
                }
                val extraFlavorOnionPrice by remember {
                    derivedStateOf { amountOnion * ONION_PRICE_PER_UNIT }
                }
                val totalPrice by remember {
                    derivedStateOf {
                        (amount * PRODUCT_PRICE_PER_UNIT + extraFlavorCheddarPrice + extraFlavorOnionPrice + extraFlavorBaconPrice)
                    }
                }

                val dec = DecimalFormat("#.##")


                ProductDetailsScreen(
                    onCheckoutClicked = {},
                    onAddItemClicked = {
                        amount = amount.inc()
                    },
                    onRemoveItemClicked = {
                        if (amount > 1) amount = amount.dec()
                    },
                    onAddCheddar = {
                        amountCheddar++
                    },
                    onAddBacon = {
                        amountBacon++
                    },
                    onAddOnion = {
                        amountOnion++
                    },
                    amountCheddar = amountCheddar,
                    amountBacon = amountBacon,
                    amountOnion = amountOnion,

                    orderState = OrderState(
                        amount = amount, totalPrice = "${PRODUCT_CURRENCY}${dec.format(totalPrice)}"
                    ),

                    onCloseButton = { finish() }
                )
            }
        }
    }
}