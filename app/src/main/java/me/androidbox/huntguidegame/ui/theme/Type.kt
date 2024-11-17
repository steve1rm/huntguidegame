package me.androidbox.huntguidegame.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.androidbox.huntguidegame.R

val orbitronFontFamily = FontFamily(
    Font(R.font.orbitron_black, FontWeight.Black),
    Font(R.font.orbitron_bold, FontWeight.Bold),
    Font(R.font.orbitron_extrabold, FontWeight.ExtraBold),
    Font(R.font.orbitron_medium, FontWeight.Medium),
    Font(R.font.orbitron_regular, FontWeight.Normal),
    Font(R.font.orbitron_semibold, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(

    titleLarge = TextStyle(
        fontFamily = orbitronFontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        lineHeight = 21.sp,
    ),

    titleMedium = TextStyle(
        fontFamily = orbitronFontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 13.sp,
        lineHeight = 11.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = orbitronFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 16.sp,
    ),
)