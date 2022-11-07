package ru.mmnigmatullov.material3.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = Violet80,
    onPrimary = Violet20,
    primaryContainer = Violet30,
    onPrimaryContainer = Violet90,
    inversePrimary = Violet40,

    secondary = DarkViolet80,
    onSecondary = DarkViolet20,
    secondaryContainer = DarkViolet30,
    onSecondaryContainer = DarkViolet90,

    tertiary = Pink80,

    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,

    background = Grey10,
    onBackground = Grey90,

    surface = GreyViolet30,
    onSurface = GreyViolet80,
    inverseSurface = Grey90,
    inverseOnSurface = Grey10,
    surfaceVariant = GreyViolet30,
    onSurfaceVariant = GreyViolet80,
    outline = GreyViolet80

)

private val LightColorScheme = lightColorScheme(
    primary = Violet40,
    onPrimary = Color.White,
    primaryContainer = Violet90,
    onPrimaryContainer = Violet10,
    inversePrimary = Violet80,

    secondary = DarkViolet40,
    onSecondary = Color.White,
    secondaryContainer = DarkViolet90,
    onSecondaryContainer = DarkViolet10,

    tertiary = Pink80,

    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,

    background = Grey99,
    onBackground = Grey10,

    surface = GreyViolet90,
    onSurface = GreyViolet30,
    inverseSurface = Grey20,
    inverseOnSurface = Grey95,
    surfaceVariant = GreyViolet90,
    onSurfaceVariant = GreyViolet30,
    outline = GreyViolet50
)

@Composable
fun Material3Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
       dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
           val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}