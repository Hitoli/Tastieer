package com.example.tastieer.category.usercase

import com.example.tastieer.category.model.CategoryResponse
import com.example.tastieer.category.repository.IGetCategoryRepository
import javax.inject.Inject

//This interface is for future testing code
interface IGetCategoryUsecase{
    suspend operator fun invoke():CategoryResponse
}

class CategoryUsecase @Inject constructor(

    val repo: IGetCategoryRepository

):IGetCategoryUsecase {

    override suspend fun invoke(): CategoryResponse {
        return repo.getAllCategories()
    }
}