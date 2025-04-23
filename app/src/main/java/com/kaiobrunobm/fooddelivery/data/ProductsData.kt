package com.kaiobrunobm.fooddelivery.data

import androidx.annotation.DrawableRes
import com.kaiobrunobm.fooddelivery.R

data class ProductState (
    val name: String,
    val description: String,
    val value: Double,
    val type: String,
    @DrawableRes val imageRes: Int,
)

val ProductsData: List<ProductState> = listOf(
    ProductState(
        name = "Frenchdog",
        description = "Savory classic",
        value = 4.69,
        imageRes = R.drawable.realistichotdog,
        type = "hot dog"
    ),
    ProductState(
        name = "Fries",
        description = "Crispy delight",
        value = 3.29,
        imageRes = R.drawable.realisticfranchfries,
        type = "fries"
    ),
    ProductState(
        name = "Vanilla Ice",
        description = "Creamy Delight",
        value = 4.69,
        imageRes = R.drawable.realisticicecream,
        type = "dessert"
    ),
    ProductState(
        name = "Americano",
        description = "Rich Aroma",
        value = 1.99,
        imageRes = R.drawable.realisticcoffe,
        type = "coffee"
    ),
    ProductState(
        name = "Mr.Cheezy",
        description = "Juicy Feast",
        value = 5.49,
        imageRes = R.drawable.realistcburger,
        type = "burger"
    ),
    ProductState(
        name = "Soda",
        description = "Fizzing Refreshment",
        value = 0.99,
        imageRes = R.drawable.realistcsoda,
        type = "drinks"
    ),
    ProductState(
        name = "Donuts",
        description = "Sweet Rings",
        value = 2.49,
        imageRes = R.drawable.realiticdonut,
        type = "dessert"
    ),
)