package com.example.tastieer.di

import com.example.tastieer.category.repository.CategoryRepository
import com.example.tastieer.category.repository.IGetCategoryRepository
import com.example.tastieer.category.services.IGetCategoryServices
import com.example.tastieer.category.usercase.CategoryUsecase
import com.example.tastieer.category.usercase.IGetCategoryUsecase
import com.example.tastieer.dishdetails.repository.DishDetailsRepository
import com.example.tastieer.dishdetails.repository.IGetDishDetailRepository
import com.example.tastieer.dishdetails.services.IGetDishDetailServices
import com.example.tastieer.dishdetails.usecase.DishDetailsUsecase
import com.example.tastieer.dishdetails.usecase.IgetDishDetailsUsecase
import com.example.tastieer.dishes.repository.DishesRepository
import com.example.tastieer.dishes.repository.IGetDishRepository
import com.example.tastieer.dishes.services.IGetDishesServices
import com.example.tastieer.dishes.usecase.DishesUsecase
import com.example.tastieer.dishes.usecase.IgetDishesUsecase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

//It is different from gradle modules
//These are files that tell HILT how to make certain code parts that need to be injected
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/").addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Provides
    @Singleton
    fun provideCategoryService(retrofit: Retrofit):IGetCategoryServices{
        return retrofit.create(IGetCategoryServices::class.java)
    }
    @Provides
    @Singleton
    fun provideDispacthers():CoroutineDispatcher{
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideDishesService(retrofit: Retrofit):IGetDishesServices{
        return retrofit.create(IGetDishesServices::class.java)
    }
    @Provides
    @Singleton
    fun provideDishesDetailsService(retrofit: Retrofit):IGetDishDetailServices{
        return retrofit.create(IGetDishDetailServices::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt{


        @Binds
        @Singleton
        fun provideCategoryRepository(repo:CategoryRepository):IGetCategoryRepository

        @Binds
        @Singleton
        fun provideCategoryUsecase(uc:CategoryUsecase):IGetCategoryUsecase

        @Binds
        @Singleton
        fun provideDishesRepository(repo:DishesRepository):IGetDishRepository

        @Binds
        @Singleton
        fun provideDishesCategory(uc:DishesUsecase):IgetDishesUsecase

        @Binds
        @Singleton
        fun provideDishDetailsRepository(repo:DishDetailsRepository):IGetDishDetailRepository

        @Binds
        @Singleton
        fun provideDishesDetailsUsecase(uc:DishDetailsUsecase):IgetDishDetailsUsecase
    }

}