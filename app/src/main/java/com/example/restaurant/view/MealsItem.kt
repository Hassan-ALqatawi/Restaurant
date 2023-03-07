package com.example.restaurant.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.domain.modle.Meal

@Composable
fun MealsItem(
    meal: Meal,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxSize().background(Color(0xFFF89345))
        ) {
            val image = rememberAsyncImagePainter(model = meal.strCategoryThumb)
            Image(painter = image,
                contentDescription = "image",
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.CenterVertically)
                    .size(width = 100.dp, height = 130.dp),
                contentScale = ContentScale.FillHeight
            )
            Column(modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFEE6700))
            ) { Text(
                    text = meal.strCategory,
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp),
                    text = meal.strCategoryDescription,
                    fontSize = 16.sp,
                    color = Color.White,
                    maxLines = 6,
                    )
            }
        }
    }
}