package com.example.restaurant

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.modle.Mealz
import com.example.domain.usecase.GetMealz
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModule @Inject constructor(
    private val getMealsUseCase: GetMealz
) : ViewModel() {
    private val _meals = mutableStateOf(Mealz(emptyList()))
    val meals: State<Mealz> = _meals

    init {
        getMeals()
    }
    private fun getMeals() {
        viewModelScope.launch {
            try {
                _meals.value = getMealsUseCase()
            } catch (e: Exception) {
                Log.d("mealsViewModel", e.message.toString())
            }
        }
    }
}