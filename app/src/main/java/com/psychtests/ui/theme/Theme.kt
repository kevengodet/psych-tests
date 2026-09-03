package com.psychtests.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF4A6572),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFB9CCD3),
    onPrimaryContainer = Color(0xFF0C1E26),
    secondary = Color(0xFF7C8790),
    onSecondary = Color.White,
    background = Color(0xFFFDFBFF),
    surface = Color(0xFFFDFBFF),
    onBackground = Color(0xFF1A1C1E),
    onSurface = Color(0xFF1A1C1E),
    error = Color(0xFFB00020)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF8FB7C5),
    onPrimary = Color(0xFF122A31),
    primaryContainer = Color(0xFF304E56),
    onPrimaryContainer = Color(0xFFD2E5EA),
    secondary = Color(0xFFA4B6BE),
    onSecondary = Color(0xFF163B45),
    background = Color(0xFF111315),
    surface = Color(0xFF111315),
    onBackground = Color(0xFFE1E2E4),
    onSurface = Color(0xFFE1E2E4),
    error = Color(0xFFCF6679)
)

@Composable
fun PsychTestsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}