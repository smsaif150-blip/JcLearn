package com.example.learnjetpackcompose.Zomato

import android.graphics.Paint
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcompose.R
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import com.example.learnjetpackcompose.ui.theme.RedJC

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Zomato()
{
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Zomato") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = RedJC,
                    titleContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {}, modifier = Modifier.padding(end = 12.dp)) {
                        Image(painter = painterResource(R.drawable.profile),
                            null, modifier = Modifier.size(40.dp))
                    }
                }
            )
        }
    )
    { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)){

            OutlinedTextField(value = "", onValueChange = {
                ""
            }, modifier = Modifier.fillMaxWidth().padding(16.dp),
                placeholder = {Text("Search restaurants...")},
                trailingIcon = {Image(painter = painterResource(R.drawable.search),null,
                    modifier = Modifier.size(30.dp))},
                shape = RoundedCornerShape(40.dp),
                colors = OutlinedTextFieldDefaults.colors(Color.White)
                )


               Card(
                   modifier = Modifier.fillMaxWidth().height(140.dp).padding(horizontal = 20.dp),
                   colors = CardDefaults.cardColors(RedJC),
                   shape = RoundedCornerShape(22.dp)
               ) {
                   Row(modifier = Modifier.fillMaxWidth()) {

                       Box(modifier = Modifier.weight(2f))
                       {
                           Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                               Text("FLAT 50% OFF", color = Color.White,fontSize = 25.sp)
                               Text("Free Delivery + 10% Cashback", color = Color.White, fontSize = 12.sp)
                               Spacer(modifier = Modifier.padding(vertical = 6.dp))
                               Text(text = "Coupon: FOOD50", color = Color.White, fontSize = 20.sp)
                           }
                       }

                       Box(modifier = Modifier.weight(1f))
                       {
                           Image(painter = painterResource(R.drawable.bannerimg),null)
                       }

                   }
               }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Text("CATEGORIES", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                CategoryCard(R.drawable.cake,"Cake")
                CategoryCard(R.drawable.pizza,"Pizza")
                CategoryCard(R.drawable.sandwiches,"Sandwiches")
            }

            Spacer(modifier = Modifier.padding(top = 30.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                CategoryCard(R.drawable.noodles,"Noodles")
                CategoryCard(R.drawable.pasta,"Pasta")
                CategoryCard(R.drawable.biryani,"Biryani")
            }

            Spacer(modifier = Modifier.padding(top = 30.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                CategoryCard(R.drawable.burger,"Burger")
                CategoryCard(R.drawable.icecream,"Ice Cream")
                CategoryCard(R.drawable.dalrice,"Dal Rice")
            }

        }
    }
}

@Composable
fun CategoryCard(image: Int,name: String)
{
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(modifier = Modifier.width(64.dp).height(64.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center)
            {
                Image(painter = painterResource(image),
                    null, modifier = Modifier.size(45.dp))
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 3.dp))
        Text(name, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 14.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun ZomatoPreview() {
    LearnJetpackComposeTheme {
        Zomato()
    }
}