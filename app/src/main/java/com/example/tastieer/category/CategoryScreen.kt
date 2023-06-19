package com.example.tastieer.category

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.tastieer.R
import com.example.tastieer.category.catergoryviewmodel.CategoryViewModel
import com.example.tastieer.category.model.Category
import com.example.tastieer.ui.theme.background1
import com.example.tastieer.ui.theme.background2
import com.example.tastieer.ui.theme.nexaheavyfont
import com.example.tastieer.ui.theme.nexalightfont


@Composable
fun CategoryScreen(viewModel: CategoryViewModel= hiltViewModel(),onItemClick:(String)->Unit) {

    val listofcategories by remember{
        viewModel.categoriesList
    }
    Column(modifier = Modifier
        .background(background2)
        .padding(20.dp)
        .fillMaxWidth()) {

        LazyColumn{
            item{
                GreetingHomeScreen()
            }
            item {
                CategoryTitle()
                Spacer(modifier = Modifier.padding(8.dp))
            }

            items(listofcategories){
                SingleCategoryItem(category = it, onClick = {
                    onItemClick(it)
                })
            }
        }
    }

    
}

@Composable
fun CategoryTitle() {
    Column(modifier = Modifier
        .background(background1, shape = RoundedCornerShape(20.dp))
        .padding(20.dp)) {
        Text(text = "Choose A Meal For Today", fontFamily = nexaheavyfont, fontSize = 30.sp)
        Spacer(modifier = Modifier.padding(8.dp))
    }
    Text(text = "Lets Get Started", fontFamily = nexalightfont, fontSize = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(16.dp))

}



@Composable
fun GreetingHomeScreen(name:String="Hitesh"){

    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()
        .padding(2.dp)) {
        Icon(painter = painterResource(id = R.drawable.profile), contentDescription ="Search", tint = Color.Black,
            modifier = Modifier
                .size(40.dp)
                .padding(0.dp) )
        Column( verticalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 0.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Good Morning!", style = MaterialTheme.typography.h6.copy(fontFamily = nexalightfont), color = Color.Black, textAlign = TextAlign.Center)
            Text(text = name, style = MaterialTheme.typography.h5.copy(fontFamily = nexalightfont), color = Color.Black,textAlign = TextAlign.Center)
        }
        Icon(painter = painterResource(id = R.drawable.menu_24), contentDescription ="Search", tint = Color.Black,
            modifier = Modifier
                .size(40.dp)
                .padding(0.dp) )

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
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onClick(category.strCategory) }, elevation = 2.dp, shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier
            .padding(0.dp)
            .background(color = Color.White, shape = RoundedCornerShape(20.dp)), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painter , contentDescription = null, modifier = Modifier.size(200.dp))
            Text(text = category.strCategory, fontFamily = nexaheavyfont, fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp))

            Log.e("paintit2",paintit2.toString())
            Log.e("paintit",painter.toString())
        }
    }


}