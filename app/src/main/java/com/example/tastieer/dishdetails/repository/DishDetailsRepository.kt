package com.example.tastieer.dishdetails.repository

import com.example.tastieer.dishdetails.model.DishDetailsResponse
import com.example.tastieer.dishdetails.services.IGetDishDetailServices
import javax.inject.Inject

interface IGetDishDetailRepository{
    suspend fun getallDishDetails(dishDetail:String):DishDetailsResponse
}

class DishDetailsRepository @Inject constructor(val services:IGetDishDetailServices):IGetDishDetailRepository{
    override suspend fun getallDishDetails(dishDetail: String): DishDetailsResponse {
        return services.getAllDishDetails(dishDetail)
    }

}