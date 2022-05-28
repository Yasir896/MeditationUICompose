package com.techlads.meditation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.compose.rememberNavController
import com.techlads.meditation.ui.theme.AppNavigation
import com.techlads.meditation.ui.theme.MeditationTheme
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MeditationTheme {
                AppNavigation(navController = navController)
            }
        }
    }
}
