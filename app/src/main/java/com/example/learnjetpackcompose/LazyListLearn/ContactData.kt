package com.example.learnjetpackcompose.LazyListLearn

import androidx.compose.runtime.Composable
import com.example.learnjetpackcompose.R

data class ContactData(
    val image: Int,
    val name: String,
    val phone: String
)


fun DummyData(): List<ContactData>
{
    return listOf(
        ContactData(R.drawable.profile,"Rahim","01745125987"),
        ContactData(R.drawable.user,"Karim","01745126848"),
        ContactData(R.drawable.bussiness,"Saif","01745124512"),
        ContactData(R.drawable.profile,"Asif","01745512464"),
        ContactData(R.drawable.bussiness,"Hasan","01745151244"),
        ContactData(R.drawable.user,"Rafi","01745112456"),
        ContactData(R.drawable.bussiness,"Rakib","01712454512"),
        ContactData(R.drawable.user,"Afnan","01745125126"),
        ContactData(R.drawable.woman,"Ikra","01745127451"),
        ContactData(R.drawable.woman,"Afrin","01745512451"),
        ContactData(R.drawable.profile,"Rahim","01745125987"),
        ContactData(R.drawable.user,"Karim","01745126848"),
        ContactData(R.drawable.bussiness,"Saif","01745124512"),
        ContactData(R.drawable.profile,"Asif","01745512464"),
        ContactData(R.drawable.bussiness,"Hasan","01745151244"),
        ContactData(R.drawable.user,"Rafi","01745112456"),
        ContactData(R.drawable.bussiness,"Rakib","01712454512"),
        ContactData(R.drawable.user,"Afnan","01745125126"),
        ContactData(R.drawable.woman,"Ikra","01745127451"),
        ContactData(R.drawable.woman,"Afrin","01745512451"),
    )
}