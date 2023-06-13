package com.example.tastieer.dishes.repository


import com.example.tastieer.dishes.modal.DishesResponse
import com.example.tastieer.dishes.services.IGetDishesServices
import javax.inject.Inject

interface IGetDishRepository{
    suspend fun getallmeals(dishcategory:String):DishesResponse
}

class DishesRepository@Inject constructor(val services: IGetDishesServices):IGetDishRepository{
    override suspend fun getallmeals(dishcategory: String): DishesResponse {
        return services.getallmeals(dishcategory)
    }

}