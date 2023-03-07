package com.example.domain.modle

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
):Parcelable