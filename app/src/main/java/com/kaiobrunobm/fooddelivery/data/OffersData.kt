package com.kaiobrunobm.fooddelivery.data

import androidx.annotation.DrawableRes
import com.kaiobrunobm.fooddelivery.R

data class OffersState (
    val title: String,
    val subtitle: String,
    @DrawableRes val imageRes: Int,
    var type: OffersType
)

enum class OffersType {
    PRIMARY, SECONDARY
}

val OffersData: List<OffersState> = listOf(
    OffersState(
        title = "Free Donut!",
        subtitle = "For orders over $20",
        imageRes = R.drawable.realiticdonut,
        type = OffersType.PRIMARY
    ),
    OffersState(
        title = "Free Delivery!",
        subtitle = "For orders over $40",
        imageRes = R.drawable.realistcsoda,
        type = OffersType.SECONDARY
    )

)
