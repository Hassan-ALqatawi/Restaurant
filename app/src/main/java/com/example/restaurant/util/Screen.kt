package com.example.restaurant.util

sealed class Screen(val route:String){
    object HomeScreen: Screen("home_screen")
    object OrderScreen: Screen("order_screen")
}
