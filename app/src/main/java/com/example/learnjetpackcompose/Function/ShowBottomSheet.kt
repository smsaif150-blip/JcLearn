package com.example.learnjetpackcompose.Function

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.learnjetpackcompose.ui.theme.GreenJc

@Composable
fun ShowBottomSheet(icon: ImageVector, title: String, onClick: () -> Unit) {
    Row(modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp).fillMaxWidth().clickable{onClick()})
    {
        Icon(icon,null, tint = GreenJc)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title)
    }
}