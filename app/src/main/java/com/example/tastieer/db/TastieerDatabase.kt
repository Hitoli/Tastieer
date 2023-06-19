package com.example.tastieer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tastieer.category.model.Category
import com.example.tastieer.dishdetails.model.MealDetails

@Database(
    entities = [da::class,Category::class], version = 1, exportSchema = false
)
abstract class TastieerDatabase:RoomDatabase() {

    abstract fun provideDAO():TastieerDAO

}