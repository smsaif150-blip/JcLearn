package com.example.learnjetpackcompose.LazyListLearn

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import com.example.learnjetpackcompose.ui.theme.Light_Gray

@Composable
fun MyLazyList()
{
    val contacts = DummyData()
    val context = LocalContext.current.applicationContext
    val colors = listOf(
        Color.Red,
        Color.Green,
        Color.Yellow,
        Color.Gray,
        Color.Magenta
    )
    Scaffold { paddingValues ->
      Column(modifier = Modifier.padding(paddingValues)) {
          Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
              Text("Contacts", fontSize = 30.sp, color = Color.Black)
          }
          LazyColumn(modifier = Modifier.fillMaxHeight().background(Light_Gray)) {
              itemsIndexed(contacts){index ,contact->
                  Card( modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp).clickable{
                      Toast.makeText(context,"Calling ${contact.name}", Toast.LENGTH_SHORT).show()
                  },
                      colors = CardDefaults.cardColors(colors[index % colors.size]),
                      shape = RoundedCornerShape(20.dp)
                  ) {
                      Row(modifier = Modifier.fillMaxWidth(),
                          verticalAlignment = Alignment.CenterVertically,
                      ) {
                          Image(painter = painterResource(contact.image),
                              contentDescription = contact.name,
                              modifier = Modifier.size(60.dp).clip(CircleShape),
                              contentScale = ContentScale.Crop)
                          Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                          Column {
                              Text(contact.name, fontSize = 18.sp, fontWeight = FontWeight.Black)
                              Text(contact.phone, fontSize = 14.sp, color = Color.Gray)
                          }

                          Spacer(modifier = Modifier.weight(1f))

                          Icon(Icons.Default.Call,null, modifier = Modifier.padding(end = 8.dp))
                      }
                  }
              }
          }
      }
    }
}



@Preview(showBackground = true)
@Composable
fun showList()
{
    LearnJetpackComposeTheme {
        MyLazyList()
    }
}