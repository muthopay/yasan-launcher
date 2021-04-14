package yasan.space.mnml.ai.launcher.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

val DarkColorPalette = darkYasanColors()
val LightColorPalette = lightYasanColors()

@Composable
fun YASANLauncherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    yasanColors: YasanColors = if (darkTheme) DarkColorPalette else LightColorPalette,
    content: @Composable() () -> Unit
) {
}