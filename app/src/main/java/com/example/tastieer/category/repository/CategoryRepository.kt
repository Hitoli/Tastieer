package com.example.tastieer.category.repository

import com.example.tastieer.category.model.CategoryResponse
import com.example.tastieer.category.services.IGetCategoryServices
import javax.inject.Inject

interface IGetCategoryRepository{
    suspend fun getAllCategories():CategoryResponse
}

class CategoryRepository @Inject constructor(val services: IGetCategoryServices):IGetCategoryRepository {

    override suspend fun getAllCategories(): CategoryResponse {
        return services.getAllCategories()
    }
}