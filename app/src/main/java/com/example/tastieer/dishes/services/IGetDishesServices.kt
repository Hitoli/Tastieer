package com.example.tastieer.dishes.services


import com.example.tastieer.dishes.modal.DishesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IGetDishesServices {

    @GET("filter.php")
    suspend fun getallmeals(@Query("c") dishcategory:String?): DishesResponse

}