package com.example.tastieer.category.catergoryviewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastieer.category.model.Category
import com.example.tastieer.category.usercase.IGetCategoryUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor( Igetusecase:IGetCategoryUsecase): ViewModel() {
    private val _categoriesList:MutableState<List<Category>> = mutableStateOf(emptyList())
    val categoriesList:State<List<Category>> = _categoriesList
    init {
        viewModelScope.launch {
            val a = Igetusecase()
            _categoriesList.value = a.categories

        }
    }

}