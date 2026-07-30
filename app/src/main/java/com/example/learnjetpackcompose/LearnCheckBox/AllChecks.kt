package com.example.learnjetpackcompose.LearnCheckBox

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

@Composable
fun AllChecks(checks: Boolean,text: String,onCkCng:(Boolean)-> Unit)
{
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checks,//আমার বর্তমান স্টেট ট্রু না ফল্স সেটা নিচ্ছে
            onCheckedChange = onCkCng// ইউজার ক্লিক করলে এটা কল হবে
        )
        Text(text)
    }
}


@Preview(showBackground = true)
@Composable
fun showPreviews()
{
    LearnJetpackComposeTheme {
        AllChecks(true,""){}
    }
}