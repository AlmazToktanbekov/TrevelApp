package com.example.trevel_application

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import com.google.gson.Gson

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "preview_screen") {
        composable("preview_screen") { PreviewScreen(navController) }
        composable("main_screen") { MainScreen(navController) }
        composable(
            "details_screen/{place}",
            arguments = listOf(navArgument("place") { defaultValue = "" })
        ) { backStackEntry ->
            val json = backStackEntry.arguments?.getString("place") ?: ""
            val place = Gson().fromJson(json, Place::class.java)
            DetailsScreen(navController, place)
        }
    }
}