package com.example.tastieer.dishdetails.services

import com.example.tastieer.dishdetails.model.DishDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IGetDishDetailServices {

    @GET("lookup.php")
    suspend fun getAllDishDetails(@Query("i")DishDetail:String):DishDetailsResponse

}