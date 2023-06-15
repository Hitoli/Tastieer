package com.example.tastieer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tastieer.category.CategoryScreen
import com.example.tastieer.dishdetails.DishDetailsScreen
import com.example.tastieer.dishes.DishesScreen
import com.example.tastieer.ui.theme.TastieerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TastieerTheme {
            Categoriesapp()
            }
        }
    }
}

@Composable
fun Categoriesapp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "category"  ){
        composable("category"){
            CategoryScreen(onItemClick = {category->
                navController.navigate("dishes/${category}")
            })
        }
        composable("dishes/{category}", arguments = listOf(navArgument("category"){
            type = NavType.StringType
        })){
            val categoryrem = remember {
                it.arguments?.getString("category")
            }
            DishesScreen(categoryrem, onDishdetailclick = {mealid->
                navController.navigate("details/${mealid}")
            })
        }
        composable("details/{mealid}", arguments = listOf(navArgument("mealid"){
            type = NavType.StringType
        })){
            val mealidrem = remember {
                it.arguments?.getString("mealid")
            }
            DishDetailsScreen(id = mealidrem)
        }
    }
    //CategoryScreen()
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TastieerTheme {
      Categoriesapp()
    }
}