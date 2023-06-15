package com.example.tastieer.dishdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tastieer.dishdetails.dishdetailsviewmodel.DishDetailsViewModel

@Composable
fun DishDetailsScreen(id:String?,viewmodel:DishDetailsViewModel= hiltViewModel()) {
    DisposableEffect(key1 = Unit){
        if(!id.isNullOrEmpty()){
            viewmodel.getallDishesDetails(id)
        }
        onDispose {}

    }

}