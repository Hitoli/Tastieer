package com.example.tastieer.category.services

import com.example.tastieer.category.model.CategoryResponse
import retrofit2.http.GET

interface IGetCategoryServices {
    @GET("categories.php")
     suspend fun getAllCategories():CategoryResponse
}
//www.themealdb.com/api/json/v1/1/categories.php