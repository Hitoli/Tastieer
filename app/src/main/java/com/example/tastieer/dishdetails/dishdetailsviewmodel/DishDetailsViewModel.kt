package com.example.tastieer.dishdetails.dishdetailsviewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastieer.dishdetails.model.MealDetails
import com.example.tastieer.dishdetails.usecase.IgetDishDetailsUsecase
import com.example.tastieer.dishes.dishesviewmodel.DishesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishDetailsViewModel @Inject constructor(val usecase:IgetDishDetailsUsecase): ViewModel() {

   private val _detailsofDishes: MutableState<MealDetails?> = mutableStateOf(null)
    val detailsofDishes: State<MealDetails?> = _detailsofDishes

    fun getallDishesDetails(DishDetails:String){
        viewModelScope.launch {
            try{
                val dishdetails = usecase(DishDetails)
                _detailsofDishes.value = dishdetails.meals[0]
                Log.e("MEAl DETAILS",dishdetails.meals[0].strMeal)
            }catch (e:Exception){
                Log.e("Error dishesViewModel",e.message.toString())
                //_listofDishes.value= DishesViewModel.ViewStates.Failure(e.message?:"Unknown Error Occured :(")
            }

        }
    }
}