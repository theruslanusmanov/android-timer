package com.github.theruslanusmanov.smartcountdowntimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Timer()
        }
    }
}

@Composable
fun MessageCard(msg: String) {
    Text(
        text = msg,
        fontWeight = FontWeight.Bold,
        fontSize = 96.sp
    )
}

@Composable
fun Input() {
    OutlinedTextField(
        value = "10 m",
        onValueChange = {},
        Modifier.background(Color.LightGray),
        textStyle = TextStyle(fontWeight = FontWeight.Bold)
    )
}

@Composable
fun Timer() {
    Column(
        Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageCard("10:33")
        Spacer(modifier = Modifier.height(4.dp))
        Input()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Timer()
}