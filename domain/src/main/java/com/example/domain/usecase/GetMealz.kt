package com.example.domain.usecase

import com.example.domain.repo.MealzRepo

class GetMealz(private val mealzRepo: MealzRepo) {
    suspend operator fun invoke()= mealzRepo.getMealsFromRepo()
}