package com.example.tastieer.dishdetails.usecase

import com.example.tastieer.dishdetails.model.DishDetailsResponse
import com.example.tastieer.dishdetails.repository.DishDetailsRepository
import javax.inject.Inject
interface IgetDishDetailsUsecase{
    suspend operator fun invoke(Dishdetails:String):DishDetailsResponse
}
class DishDetailsUsecase @Inject constructor(val repo:DishDetailsRepository):IgetDishDetailsUsecase{
    override suspend fun invoke(Dishdetails: String): DishDetailsResponse {
        return repo.getallDishDetails(Dishdetails)
    }

}