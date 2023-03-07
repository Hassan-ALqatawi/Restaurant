package com.example.data.remote

import com.example.domain.modle.Mealz
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getMeals(): Mealz
}