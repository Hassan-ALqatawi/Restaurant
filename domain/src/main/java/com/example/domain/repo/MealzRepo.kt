package com.example.domain.repo

import com.example.domain.modle.Mealz

interface MealzRepo {
    suspend fun getMealsFromRepo():Mealz
}