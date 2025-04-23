package com.kaiobrunobm.fooddelivery.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.kaiobrunobm.fooddelivery.R

data class TypesState (
    val name: String,
    @DrawableRes val imageRes: Int,
    val backgroundColor: Color,
)


val TypesData: List<TypesState> = listOf(
    TypesState(
        name = "Burgers",
        imageRes = R.drawable.realistcburger,
        backgroundColor = Color(0XFFFFEF92)
    ),
    TypesState(
        name = "Hot dogs",
        imageRes = R.drawable.realistichotdog,
        backgroundColor = Color(0XFFA9D7DA),
    ),
    TypesState(
        name = "Drinks",
        imageRes = R.drawable.realistcsoda,
        backgroundColor = Color(0XFFF5CAC3)
    ),
    TypesState(
        name = "Fries",
        imageRes = R.drawable.realisticfranchfries,
        backgroundColor = Color(0XFFB6D7CF),

    ),
    TypesState(
        name = "Dessert",
        imageRes = R.drawable.realiticdonut,
        backgroundColor = Color(0XFFFFEF92)
    ),
    TypesState(
        name = "Coffee",
        imageRes = R.drawable.realisticcoffe,
        backgroundColor = Color(0XFFA9D7DA),

    ),


)