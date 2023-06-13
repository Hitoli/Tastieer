package com.example.tastieer.dishes.dishesviewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastieer.dishes.modal.Meal
import com.example.tastieer.dishes.usecase.IgetDishesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(val usecase: IgetDishesUsecase):ViewModel() {

    private val _listofDishes:MutableState<List<Meal>> = mutableStateOf(emptyList())
    val listofDishes: State<List<Meal>> = _listofDishes

    fun getallDishes(DishName:String){
        viewModelScope.launch {
            val dishlist = usecase(DishName)
            _listofDishes.value = dishlist.meals
        }
    }

}