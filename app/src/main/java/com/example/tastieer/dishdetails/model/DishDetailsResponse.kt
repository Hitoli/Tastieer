package com.example.tastieer.dishdetails.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DishDetailsResponse(
    @Json(name = "meals")
    val meals: List<MealDetails>
)