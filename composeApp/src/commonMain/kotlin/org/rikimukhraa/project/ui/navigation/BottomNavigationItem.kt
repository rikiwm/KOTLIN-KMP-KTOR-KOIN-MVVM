package org.rikimukhraa.project.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.rikimukhraa.project.navigation.Screen

@Serializable
data  class  BottomNavigationItem (
    @SerialName("label")
    val label : String? = "",
    @Contextual
    val icon : ImageVector = Icons.Filled.Home,
    @SerialName("route")
    val route : String = ""
) {

    fun  bottomNavigationItems () : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home" ,
                icon =Icons.Filled.Home ,
                route = Screen.Home.route
            ),
            BottomNavigationItem(
                label = "Product" ,
                icon = Icons.Filled.Menu,
                route = Screen.Product.route
            ),
            BottomNavigationItem(
                label = "Profile" ,
                icon = Icons.Filled.AccountCircle,
                route = Screen.Profile.route
            ),
        )
    }
}