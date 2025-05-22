package ar.edu.ort.testingapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import ar.edu.ort.testingapp.R
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.GoogleFont.Provider
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.font.FontWeight

<<<<<<< HEAD
val fontName = GoogleFont("Poppins")
=======
val fontName = GoogleFont("Lobster Two")
>>>>>>> 3355da1 (Testing fonts)

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)



val fontFamilyPoppins = FontFamily(
    Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Light),
    Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Medium),
    Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.SemiBold)
)


val typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 45.sp,
        lineHeight = 64.sp,
        letterSpacing = 0.sp,
        color = Blue80
    ),
    labelSmall = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Medium,
        fontSize = 25.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)


