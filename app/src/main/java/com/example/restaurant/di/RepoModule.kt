package com.example.restaurant.di

import com.example.data.remote.ApiService
import com.example.data.repo.MealsRepoImpl
import com.example.domain.repo.MealzRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun providerRepo(apiService: ApiService):MealzRepo{
        return MealsRepoImpl(apiService)
    }
}