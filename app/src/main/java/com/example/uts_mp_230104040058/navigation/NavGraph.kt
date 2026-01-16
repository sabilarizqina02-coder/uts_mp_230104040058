package com.example.uts_mp_230104040058.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.uts_mp_230104040058.data.PrefsManager
import com.example.uts_mp_230104040058.ui.screens.SplashScreen
import com.example.uts_mp_230104040058.ui.screens.LoginScreen
import com.example.uts_mp_230104040058.ui.screens.DashboardScreen

object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val DASHBOARD = "dashboard"
}

@Composable
fun AppNavHost(
    prefs: PrefsManager,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        // Splash
        composable(route = Routes.SPLASH) {
            SplashScreen(
                prefs = prefs,
                onNavigateToLogin = { navController.navigate(Routes.LOGIN) },
                onNavigateToDashboard = { username ->
                    navController.navigate("${Routes.DASHBOARD}/${username}")
                }
            )
        }

        // Login
        composable(route = Routes.LOGIN) {
            LoginScreen(
                prefs = prefs,
                onLoginSuccess = { username ->
                    navController.navigate("${Routes.DASHBOARD}/${username}") {
                        // optional: clear backstack until splash (adjust if perlu)
                        popUpTo(Routes.SPLASH) { inclusive = false }
                    }
                },
                onBackToSplash = { navController.navigate(Routes.SPLASH) }
            )
        }

        // Dashboard with username argument
        composable(
            route = "${Routes.DASHBOARD}/{username}",
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStackEntry: NavBackStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            DashboardScreen(
                prefs = prefs,
                username = username,
                onLogout = {
                    prefs.clearUsername()
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.SPLASH) { inclusive = false }
                    }
                }
            )
        }
    }
}
