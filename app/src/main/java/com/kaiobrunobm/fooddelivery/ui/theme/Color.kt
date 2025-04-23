package com.kaiobrunobm.fooddelivery.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


val Pink = Color(0xFFF28482)
val Green = Color(0xFF84A59D)
val LightGray = Color(0xFFF5F5F5)
val TextGray = Color(0xFFABADB7)
val Yellow = Color(0xFFF7EDE2)
val YellowLight = Color(0xFFFFFFF2)
val Dark = Color(0xFF3D405B)
val DarkYellow = Color(0XFFF6BD60)

@Immutable
data class AppColors(
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val searchBar: Color,
    val onSearchBar: Color,
    val secondarySurface: Color,
    val onSecondarySurface: Color,
    val regularSurface: Color,
    val onRegularSurface: Color,
    val actionsSurface: Color,
    val onActionSurface: Color,
    val hightlightSurface: Color,
    val onHightlightSurface: Color,
    val secondaryBackground: Color
)

val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        background = Color.Unspecified,
        onBackground = Color.Unspecified,
        surface = Color.Unspecified,
        onSurface = Color.Unspecified,
        searchBar = Color.Unspecified,
        onSearchBar = Color.Unspecified,
        secondarySurface = Color.Unspecified,
        onSecondarySurface = Color.Unspecified,
        regularSurface = Color.Unspecified,
        onRegularSurface = Color.Unspecified,
        actionsSurface = Color.Unspecified,
        onActionSurface = Color.Unspecified,
        hightlightSurface = Color.Unspecified,
        onHightlightSurface = Color.Unspecified,
        secondaryBackground = Color.Unspecified
    )
}

val extendedColors = AppColors(
    background = Color.White,
    onBackground = Dark,
    surface = Color.White,
    onSurface = Dark,
    searchBar = LightGray,
    onSearchBar = TextGray,
    secondarySurface = Pink,
    onSecondarySurface = Color.White,
    regularSurface = YellowLight,
    onRegularSurface = Dark,
    actionsSurface = Yellow,
    onActionSurface = Pink,
    hightlightSurface = Green,
    onHightlightSurface = Color.White,
    secondaryBackground = DarkYellow
)