package com.example.learnjetpackcompose.Function

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcompose.R

@Composable
fun LoginPage()
{
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        .imePadding(),//imepadding ইডিট টেক্সটা কিবোর্ডের উপরে দেখানোর জন্য
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
      Image(painter = painterResource(R.drawable.login),
          contentDescription =null,
          modifier = Modifier.width(180.dp).height(180.dp)
      )

        Text(text = "Welcome back!", fontSize = 25.sp, color = Color.Black)
        Text(text = "Login to your account", fontSize = 12.sp, color = Color.Black)

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier.padding(vertical = 10.dp),
            label = {Text(text = "Email")}
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {Text("Password")},
            visualTransformation = PasswordVisualTransformation()
        )

        Button(onClick = {}, modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Login")
        }
    }
}