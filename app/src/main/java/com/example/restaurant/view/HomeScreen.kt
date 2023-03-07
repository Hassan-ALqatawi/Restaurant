package com.example.restaurant.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.restaurant.MealsViewModule
import com.example.restaurant.R
import com.example.restaurant.util.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MealsViewModule = hiltViewModel()
) {
    val meals = viewModel.meals.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Text(
                            text = stringResource(id = R.string.app_name),
                            fontSize = 22.sp,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 4.dp),
                            textAlign = TextAlign.Center
                        )
                })
        }
    ) {

        Spacer(modifier = Modifier.height(6.dp))
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(meals.categories) { meal ->
                            MealsItem(
                           meal = meal,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp)
                                .shadow(elevation = 4.dp,
                                    shape = RoundedCornerShape(topEndPercent =15, bottomStartPercent = 15))
                                .background(Color.White)
                               .clickable {
                                    navController.currentBackStackEntry?.savedStateHandle?.set(
                                       key = "dish",
                                        value = meal
                                   )
                                    navController.navigate(Screen.OrderScreen.route)
                                }
                        )
                    }

            }
        }

    }

}