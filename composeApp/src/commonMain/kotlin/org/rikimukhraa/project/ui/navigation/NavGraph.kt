package org.rikimukhraa.project.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.rikimukhraa.project.screen.detail.DetailScreen
import org.rikimukhraa.project.screen.detail.ProductScreen
import org.rikimukhraa.project.screen.home.Homecreen
import org.rikimukhraa.project.ui.auth.FirebaseAuthManager
import org.rikimukhraa.project.ui.auth.LoginScreen
import org.rikimukhraa.project.ui.navigation.BottomNavigationItem
import org.rikimukhraa.project.ui.profile.ProfileScreen
import kotlin.math.absoluteValue


@Composable
fun BottomNavbar(){
var navigationSelectedItem = remember { mutableIntStateOf(0) }
val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val shouldShowBottomNav = remember { mutableStateOf(false) }

Scaffold(
modifier = Modifier.fillMaxSize(),
bottomBar = {

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,

    ) {
        BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                ),
                selected = index.absoluteValue == navigationSelectedItem.value,
                label = {
                    navigationItem.label?.let {
                        Text(
                            it,
                            modifier = Modifier,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                },
                icon = {
                    navigationItem.icon?.let {
                        Icon(
                            it,
                            contentDescription = navigationItem.label,
                            modifier = Modifier,
                            tint = if (index == navigationSelectedItem.value) Color.DarkGray else Color.Gray,
                        )
                    }
                },
                onClick = {
                    navigationSelectedItem.value = index
                    navController.navigate(navigationItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
)
{
    SetupNavGraph(navController = navController, startDestination = Screen.Home.route)
}
}
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Home.route,
){
    NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier =  Modifier
                .fillMaxSize()
                .padding(2.dp),
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(800)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(800)
                    )
                },
                popEnterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(800)
                    )
                },
                popExitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(800)
                    )
                }
            )
//
    {
        composable(route = Screen.Home.route) {backStackEntry->
            Homecreen(
                onNavigateToDetail = { productId -> navController.navigate("productDetail/$productId")}
            )
        }

        composable(route = Screen.Product.route) {
            ProductScreen(
            )
        }

        composable(route = "productDetail/{productId}") {backStackEntry->
            val productId: String? = backStackEntry.arguments?.getString("productId") ?: "Unknown"
            DetailScreen(
                shouldShowBottomNav = { mutableStateOf(true) },

                navigateBack = { navController.popBackStack()},
                productId = productId
            )
        }

        composable(route = Screen.Login.route) {
            LoginScreen(
                authManager = FirebaseAuthManager(),
            )
        }

    }

}
