package com.kaiobrunobm.fooddelivery.data

import androidx.annotation.DrawableRes

data class ProductFlavorState(
    val name: String,
    val price: String,
    @DrawableRes val imageRes: Int,
    )

