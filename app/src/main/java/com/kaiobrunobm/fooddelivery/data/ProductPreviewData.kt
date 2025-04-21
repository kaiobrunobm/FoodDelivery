package com.kaiobrunobm.fooddelivery.data

import androidx.annotation.DrawableRes
import com.kaiobrunobm.fooddelivery.R

data class ProductHighlightState (
    val text : String,
    val type : ProductHighlightType
)

enum class ProductHighlightType {
    PRIMARY, SECONDARY
}

data class ProductPreviewState (
    val headline: String = "Mr. Cheezy",
    @DrawableRes val productImg: Int = R.drawable.burguerimage,
    val highlight: List<ProductHighlightState> = listOf(
        ProductHighlightState(
            text = "Classic Taste",
            type = ProductHighlightType.SECONDARY
        ),
        ProductHighlightState(
            text = "Bestseller",
            type = ProductHighlightType.PRIMARY
        )
    )
)