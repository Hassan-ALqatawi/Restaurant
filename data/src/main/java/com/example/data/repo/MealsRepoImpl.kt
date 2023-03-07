package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.modle.Mealz
import com.example.domain.repo.MealzRepo

class MealsRepoImpl(private val apiService: ApiService):MealzRepo {
    override suspend fun getMealsFromRepo(): Mealz = apiService.getMeals()
}