package com.example.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.checkbox.ui.theme.CheckboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckboxTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckboxExample(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CheckboxExample(name: String, modifier: Modifier = Modifier) {
    val maleCheckboxValue = remember {
        mutableStateOf(false)
    }

    val femaleCheckboxValue = remember {
        mutableStateOf(false)
    }

    val fixedText = remember {
        mutableStateOf("Select Your Gender")
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = fixedText.value,
            modifier = Modifier
                .background(color = Color.Red, shape = RoundedCornerShape(10.dp))
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
            color = Color.White,
        )

        Spacer(Modifier.size(20.dp))

        Row(modifier = Modifier.width(150.dp)) {
            Checkbox(
                checked = maleCheckboxValue.value,
                onCheckedChange = {
                    maleCheckboxValue.value = true
                    femaleCheckboxValue.value = false
                    fixedText.value = "Your gender is male"
                },
            )

            Text(
                text = "Male",
                modifier = Modifier.padding(top = 10.dp),
                color = Color.White
            )
        }

        Row(modifier = Modifier.width(150.dp)) {
            Checkbox(
                checked = femaleCheckboxValue.value,
                onCheckedChange = {
                    femaleCheckboxValue.value = true
                    maleCheckboxValue.value = false
                    fixedText.value = "Your gender is female"
                }
            )

            Text(
                text = "Female",
                modifier = Modifier.padding(top = 10.dp),
                color = Color.White
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CheckboxTheme {
        CheckboxExample("Android")
    }
}