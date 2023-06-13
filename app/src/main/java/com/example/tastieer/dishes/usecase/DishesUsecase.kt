package com.example.tastieer.dishes.usecase


import com.example.tastieer.dishes.modal.DishesResponse
import com.example.tastieer.dishes.repository.DishesRepository
import javax.inject.Inject

interface IgetDishesUsecase{
    suspend operator fun invoke(selectedDishes:String): DishesResponse
}
class DishesUsecase @Inject constructor(private val repo:DishesRepository):IgetDishesUsecase{
    override suspend fun invoke(selectedDishes: String): DishesResponse {
        return repo.getallmeals(dishcategory = selectedDishes)
    }

}