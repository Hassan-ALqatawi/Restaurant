package com.example.restaurant

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.domain.modle.Meal
import com.example.restaurant.ui.theme.RestaurantTheme
import com.example.restaurant.util.Screen
import com.example.restaurant.view.HomeScreen
import com.example.restaurant.view.OrderScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeScreen.route
                ) {
                    composable(route = Screen.HomeScreen.route) {
                        HomeScreen(navController = navController)
                    }
                    composable(Screen.OrderScreen.route) {
                        val result =
                            navController.previousBackStackEntry?.savedStateHandle?.get<Meal>("dish")
                        if (result != null) { OrderScreen(meal = result) }
                    }
                }
            }
        }
    }
}

