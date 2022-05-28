package com.techlads.meditation.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


/**
 * Created by Yasir on 5/21/2022.
 */
@ExperimentalFoundationApi
@Composable
fun AppNavigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "home_screen",) {
                composable( route = "home_screen") {
                        HomeScreen(navController)
                }
                composable( route = "details_screen") {
                        MeditationDetailsScreen(navController)
                }
        }
}