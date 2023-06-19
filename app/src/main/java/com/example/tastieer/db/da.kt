package com.example.tastieer.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_details")
data class da(
    @PrimaryKey
    val mealID:String,
    val mealName:String)



