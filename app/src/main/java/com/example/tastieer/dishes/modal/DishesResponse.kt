package com.example.tastieer.dishes.modal


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DishesResponse(
    @Json(name = "meals")
    val meals: List<Meal>
)