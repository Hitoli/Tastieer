package com.example.tastieer.category.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@Entity(tableName = "Categories")
@JsonClass(generateAdapter = true)
data class Category(
    @PrimaryKey
    @Json(name = "idCategory")
    val idCategory: String,
    @Json(name = "strCategory")
    val strCategory: String,
    @Json(name = "strCategoryDescription")
    val strCategoryDescription: String,
    @Json(name = "strCategoryThumb")
    val strCategoryThumb: String
)