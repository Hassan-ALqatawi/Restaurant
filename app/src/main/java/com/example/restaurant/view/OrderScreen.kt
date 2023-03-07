package com.example.restaurant.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.domain.modle.Meal

@Composable
fun OrderScreen(meal: Meal) {
    Column(modifier = Modifier.fillMaxSize()
    ) {
         val context = LocalContext.current
         val image = rememberAsyncImagePainter(model = meal.strCategoryThumb)
        Image(painter = image,
            contentDescription ="",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF89345))
                .height(200.dp),
          contentScale = ContentScale.FillWidth
       )
        Column(modifier = Modifier
                .background(Color(0xFFEE6700))
        ) {
            Text(
                text = meal.strCategory,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = meal.strCategoryDescription,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .padding(start = 4.dp)
                    .verticalScroll(rememberScrollState()))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Number(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 22.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            Toast.makeText(context," The Order in the way !",Toast.LENGTH_LONG).show()
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            shape = CutCornerShape(12.dp)
        ) {
            Text(text = "Order in the way")

        }
    }
}

@Composable
fun Number(modifier: Modifier = Modifier) {
    var cont by remember { mutableStateOf(1) }
    Row( verticalAlignment = Alignment.CenterVertically, modifier =modifier
    ) {
        Button(onClick = {
            if (1 < cont) cont--
        }, modifier = Modifier
            , colors = ButtonDefaults.buttonColors(MaterialTheme.colors.background)
        ) {
            Text(text = "-", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            ) }
        Text(text = cont.toString(), fontSize = 18.sp, color = Color.Black,
            modifier= Modifier.padding(start = 16.dp, end = 16.dp))
        Button(onClick = { cont++},
             colors = ButtonDefaults.buttonColors(MaterialTheme.colors.background),
        ) { Text(text = "+", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            ) }
    }
}