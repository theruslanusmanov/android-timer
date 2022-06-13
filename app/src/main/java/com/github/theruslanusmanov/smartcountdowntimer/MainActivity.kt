package com.github.theruslanusmanov.smartcountdowntimer

import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

// TODO: Use Jchronic or Natty to parse time
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Timer(this)
        }
    }
}

@Composable
fun TimeView(msg: String) {
    Text(
        text = msg,
        fontWeight = FontWeight.Bold,
        fontSize = 96.sp
    )
}

@Composable
fun TimePicker(context: Context) {
    val calendar = Calendar.getInstance()
    val hour = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    val time = remember { mutableStateOf("") }
    val timePickerDialog = TimePickerDialog(
        context,
        { _, hour: Int, minute: Int ->
            time.value = "$hour:$minute"
        }, hour, minute, false
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selected Time: ${time.value}")
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = {
            timePickerDialog.show()
        }) {
            Text(text = "Open Time Picker")
        }
    }
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
fun Timer(ctx: Context) {
    Column(
        Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimeView("10:33")
        Spacer(modifier = Modifier.height(4.dp))
        // Input()
        TimePicker(context = ctx)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Timer()
}