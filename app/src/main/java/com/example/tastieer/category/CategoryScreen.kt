package com.example.tastieer.category

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.tastieer.category.catergoryviewmodel.CategoryViewModel
import com.example.tastieer.category.model.Category




@Composable
fun CategoryScreen(viewModel: CategoryViewModel= hiltViewModel(),onItemClick:(String)->Unit) {

    val listofcategories by remember{
        viewModel.categoriesList
    }
    LazyColumn{
            items(listofcategories){
                SingleCategoryItem(category = it, onClick = {
                    onItemClick(it)
                })
            }
        }
    
}

@Composable
fun SingleCategoryItem(category:Category,onClick:(String)->Unit) {
    val paintit2 = category.strCategoryThumb
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(paintit2)
            .build()
    )
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp).clickable { onClick(category.strCategory) }, elevation = 5.dp) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painter , contentDescription = null, modifier = Modifier.size(80.dp))
            Text(text = category.strCategory)
            Log.e("paintit2",paintit2.toString())
            Log.e("paintit",painter.toString())
        }
    }


}