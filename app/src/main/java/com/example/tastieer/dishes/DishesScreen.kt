package com.example.tastieer.dishes

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.tastieer.category.SingleCategoryItem
import com.example.tastieer.category.model.Category
import com.example.tastieer.dishes.dishesviewmodel.DishesViewModel
import com.example.tastieer.dishes.modal.Meal
import com.example.tastieer.ui.theme.background1
import com.example.tastieer.ui.theme.nexaheavyfont
import com.example.tastieer.ui.theme.nexalightfont

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
                item {
                    CategoryTitleSub(categories.toString())
                }
            items(state.data){
                SingleDishScreen(meal = it,onDishdetailclick)
            }
        }
    }


    //Text(text = viewModel.listofDishes.value.toString())
}
@Composable
fun CategoryTitleSub(NameCategory:String) {
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
        .background(background1, shape = RoundedCornerShape(0.dp))
        .padding(30.dp), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = NameCategory, fontFamily = nexaheavyfont, fontSize = 30.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Lets Get Cooking", fontFamily = nexalightfont, fontSize = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(16.dp))

    }

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
        .clickable { onClick(meal.idMeal) }, elevation = 2.dp, shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier
            .padding(0.dp)
            .background(color = Color.White, shape = RoundedCornerShape(20.dp)), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painter , contentDescription = null, modifier = Modifier.size(200.dp).padding(16.dp))
            Text(text = meal.strMeal, fontFamily = nexaheavyfont, fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp))

            Log.e("paintit2",Dishit2.toString())
            Log.e("paintit",painter.toString())
        }
    }
}


