package com.example.tastieer.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.tastieer.category.model.Category
import com.example.tastieer.category.model.CategoryResponse
import com.example.tastieer.dishdetails.model.MealDetails

@Dao
interface TastieerDAO {

    @Query("SELECT * FROM meal_details")
    suspend fun getListofmeals():List<da>

    @Insert(onConflict = REPLACE)
    suspend fun savetofav(meal : da)

    @Query("SELECT * FROM Categories")
    suspend fun getAllCategoriesSave():List<Category>

    @Insert(onConflict = REPLACE)
    suspend fun saveCategoryResponse(listcategories:List<Category>)
}