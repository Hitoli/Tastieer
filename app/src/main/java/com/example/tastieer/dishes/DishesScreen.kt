package com.example.tastieer.dishes

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tastieer.dishes.dishesviewmodel.DishesViewModel

@Composable
fun DishesScreen(categories:String?,viewModel: DishesViewModel= hiltViewModel()) {
    viewModel.getallDishes(DishName = categories!!)
    Text(text = viewModel.listofDishes.value.toString())
}