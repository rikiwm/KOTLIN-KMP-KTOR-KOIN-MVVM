package org.rikimukhraa.project.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import org.rikimukhraa.project.ui.navigation.BottomNavigationItem


sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Product : Screen("product")
    data object Profile : Screen("profile")

    data object Detail : Screen("productDetail")
//    data object Login : Screen("login")
//    data object Regis : Screen("regis")
}