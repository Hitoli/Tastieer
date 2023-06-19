package com.example.tastieer.dishes

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.tastieer.category.SingleCategoryItem
import com.example.tastieer.dishes.dishesviewmodel.DishesViewModel
import com.example.tastieer.dishes.modal.Meal

@Composable
fun DishesScreen(categories:String?,viewModel: DishesViewModel= hiltViewModel(),onDishdetailclick:(String)->Unit) {

    DisposableEffect(key1 = Unit) {
        if (!categories.isNullOrEmpty()) {
            viewModel.getallDishes(DishName = categories)
        }
        onDispose {  }
    }
    val viewstate by remember {
        viewModel.listofDishes
    }
    when(val state = viewstate) {
        is DishesViewModel.ViewStates.Failure -> Text(text = "Failure")
        DishesViewModel.ViewStates.Loading -> Text(text = "Loading")
        is DishesViewModel.ViewStates.Success ->
            LazyColumn{
            items(state.data){
                SingleDishScreen(meal = it,onDishdetailclick)
            }
        }
    }


    //Text(text = viewModel.listofDishes.value.toString())
}

@Composable
fun SingleDishScreen(meal: Meal,onClick:(String)->Unit) {
    val Dishit2 = meal.strMealThumb
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(Dishit2)
            .build()
    )
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onClick(meal.idMeal) }, elevation = 5.dp) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painter , contentDescription = null, modifier = Modifier.size(80.dp))
            Text(text = meal.strMeal)
            Log.e("paintit2",Dishit2.toString())
            Log.e("paintit",painter.toString())
        }
    }
}


