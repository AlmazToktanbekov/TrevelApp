package com.example.trevel_application.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.trevel_application.DetailsScreen
import com.example.trevel_application.Place
import com.example.trevel_application.screens.ListScreen
import com.example.trevel_application.screens.MainScreen
import com.example.trevel_application.screens.PreviewScreen

import com.google.gson.Gson

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "preview_screen"
    ) {
        composable("preview_screen") { PreviewScreen(navController) }
        composable("main_screen") { MainScreen(navController) }
        composable("list_screen") { ListScreen(navController) }
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