package com.luizvicari.moodtracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luizvicari.moodtracker.ui.auth.SignInScreen
import com.luizvicari.moodtracker.ui.auth.SignUpScreen

sealed class Screen(val route: String) {
    data object SignIn: Screen("signIn")
    data object SignUp: Screen("signUp")
    data object Home: Screen("home")
}

@Composable
fun MoodTrackerNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.SignUp.route) {
        composable(Screen.SignUp.route) {
            SignUpScreen(onNavigateToSignIn = {navController.navigate(Screen.SignIn.route)})
        }
        composable(Screen.SignIn.route) {
            SignInScreen()
        }
    }
}