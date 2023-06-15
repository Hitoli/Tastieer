package com.example.tastieer.dishes.dishesviewmodel

import android.util.Log
import android.view.View
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
    sealed class ViewStates{
        object Loading:ViewStates()
        class Success(val data: List<Meal>) : ViewStates()
        class Failure(val data2:String):ViewStates()
    }

    private val _listofDishes:MutableState<ViewStates> = mutableStateOf(ViewStates.Loading)
    val listofDishes: State<ViewStates> = _listofDishes

    fun getallDishes(DishName:String){
        viewModelScope.launch {
            try{
                val dishlist = usecase(DishName)
                _listofDishes.value = ViewStates.Success(dishlist.meals)
            }catch (e:Exception){
                Log.e("Error dishesViewModel",e.message.toString())
                _listofDishes.value= ViewStates.Failure(e.message?:"Unknown Error Occured :(")
            }

        }
    }

}