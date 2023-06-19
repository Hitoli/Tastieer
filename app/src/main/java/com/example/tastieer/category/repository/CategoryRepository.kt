package com.example.tastieer.category.repository

import android.util.Log
import com.example.tastieer.category.model.CategoryResponse
import com.example.tastieer.category.services.IGetCategoryServices
import com.example.tastieer.db.TastieerDAO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface IGetCategoryRepository{
    suspend fun getAllCategories():CategoryResponse
}

class CategoryRepository @Inject constructor(val services: IGetCategoryServices,val dao: TastieerDAO, val dispatcher: CoroutineDispatcher):IGetCategoryRepository {

    override suspend fun getAllCategories(): CategoryResponse {
        return withContext(dispatcher) {
            val response = try {
                val categorydat = services.getAllCategories()
                dao.saveCategoryResponse(categorydat.categories)
                categorydat
            } catch (e: Exception) {
                Log.e("ERROR with category Repository", "{${e.message}}")
                val CacheCateggoryResponse = dao.getAllCategoriesSave()
                CategoryResponse(CacheCateggoryResponse)
            }
             response
        }
    }
}