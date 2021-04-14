package yasan.space.mnml.ai.launcher.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

val MyAppIcons = Icons.Outlined

private val DarkColorPalette = darkColors(
    primary = YasanOrange,
    primaryVariant = YasanOrangeDark,
    secondary = YasanBlue
)

private val LightColorPalette = lightColors(
    primary = YasanBlue,
    primaryVariant = YasanBlueDark,
    secondary = YasanOrange
)

@Composable
fun YASANLauncherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}