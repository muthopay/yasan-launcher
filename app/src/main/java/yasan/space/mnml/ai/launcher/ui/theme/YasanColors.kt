package yasan.space.mnml.ai.launcher.ui.theme

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Stable
class YasanColors(
    primary: Color,
    primaryDark: Color,
    primaryLight: Color,
    onPrimary: Color,
    secondary: Color,
    secondaryDark: Color,
    secondaryLight: Color,
    onSecondary: Color,
    background: Color,
    midground: Color,
    foreground: Color,
    isLight: Boolean
) {

    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set
    var primaryDark by mutableStateOf(primaryDark, structuralEqualityPolicy())
        internal set
    var primaryLight by mutableStateOf(primaryLight, structuralEqualityPolicy())
        internal set
    var onPrimary by mutableStateOf(onPrimary, structuralEqualityPolicy())
        internal set
    var secondary by mutableStateOf(secondary, structuralEqualityPolicy())
        internal set
    var secondaryDark by mutableStateOf(secondaryDark, structuralEqualityPolicy())
        internal set
    var secondaryLight by mutableStateOf(secondaryLight, structuralEqualityPolicy())
        internal set
    var onSecondary by mutableStateOf(onSecondary, structuralEqualityPolicy())
        internal set
    var background by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    var midground by mutableStateOf(midground, structuralEqualityPolicy())
        internal set
    var foreground by mutableStateOf(foreground, structuralEqualityPolicy())
        internal set
    var isLight by mutableStateOf(isLight, structuralEqualityPolicy())
        internal set

}

fun lightYasanColors(
    primary: Color = YasanBlue,
    primaryDark: Color = YasanBlueDark,
    primaryLight: Color = YasanBlueLight,
    onPrimary: Color = OnPrimaryLight,
    secondary: Color = YasanOrange,
    secondaryDark: Color = YasanOrangeDark,
    secondaryLight: Color = YasanOrangeLight,
    onSecondary: Color = OnSecondaryLight,
    background: Color = LayerBackgroundLight,
    midground: Color = LayerMidgroundLight,
    foreground: Color = LayerForegroundLight,
): YasanColors = YasanColors(
    primary,
    primaryDark,
    primaryLight,
    onPrimary,
    secondary,
    secondaryDark,
    secondaryLight,
    onSecondary,
    background,
    midground,
    foreground,
    true
)

fun darkYasanColors(
    primary: Color = YasanOrange,
    primaryDark: Color = YasanOrangeDark,
    primaryLight: Color = YasanOrangeLight,
    onPrimary: Color = OnPrimaryDark,
    secondary: Color = YasanBlue,
    secondaryDark: Color = YasanBlueDark,
    secondaryLight: Color = YasanBlueLight,
    onSecondary: Color = OnSecondaryDark,
    background: Color = LayerBackgroundDark,
    midground: Color = LayerMidgroundDark,
    foreground: Color = LayerForegroundDark,
): YasanColors = YasanColors(
    primary,
    primaryDark,
    primaryLight,
    onPrimary,
    secondary,
    secondaryDark,
    secondaryLight,
    onSecondary,
    background,
    midground,
    foreground,
    false
)

internal fun YasanColors.updateColorsFrom(other: YasanColors) {
    primary = other.primary
    primaryDark = other.primaryDark
    primaryLight = other.primaryLight
    onPrimary = other.onPrimary
    secondary = other.secondary
    secondaryDark = other.secondaryDark
    secondaryLight = other.secondaryLight
    onSecondary = other.onSecondary
    background = other.background
    midground = other.midground
    foreground = other.foreground
    isLight = other.isLight
}

internal val LocalColors = staticCompositionLocalOf { lightYasanColors() }