package com.kaiobrunobm.fooddelivery.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


val Pink = Color(0xFFF28482)
val Green = Color(0xFF84A59D)
val Yellow = Color(0xFFF7EDE2)
val YellowLight = Color(0xFFFFFFF2)
val Dark = Color(0xFF3D405B)

@Immutable
data class AppColors(
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val secondarySurface: Color,
    val onSecondarySurface: Color,
    val regularSurface: Color,
    val onRegularSurface: Color,
    val actionsSurface: Color,
    val onActionSurface: Color,
    val hightlightSurface: Color,
    val onHightlightSurface: Color
)

val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        background = Color.Unspecified,
        onBackground = Color.Unspecified,
        surface = Color.Unspecified,
        onSurface = Color.Unspecified,
        secondarySurface = Color.Unspecified,
        onSecondarySurface = Color.Unspecified,
        regularSurface = Color.Unspecified,
        onRegularSurface = Color.Unspecified,
        actionsSurface = Color.Unspecified,
        onActionSurface = Color.Unspecified,
        hightlightSurface = Color.Unspecified,
        onHightlightSurface = Color.Unspecified
    )
}

val extendedColors = AppColors(
    background = Color.White,
    onBackground = Dark,
    surface = Color.White,
    onSurface = Dark,
    secondarySurface = Pink,
    onSecondarySurface = Color.White,
    regularSurface = YellowLight,
    onRegularSurface = Dark,
    actionsSurface = Yellow,
    onActionSurface = Pink,
    hightlightSurface = Green,
    onHightlightSurface = Color.White
)