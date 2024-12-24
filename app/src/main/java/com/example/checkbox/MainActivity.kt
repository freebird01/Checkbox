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
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.unit.sp
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

    val myColor =  0xFFF44336

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF027CCD)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = fixedText.value,
            modifier = Modifier
                .width(300.dp)
                .background(color = Color(myColor), shape = RoundedCornerShape(10.dp))
                .padding(top = 15.dp, bottom = 15.dp),
            color = Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = maleCheckboxValue.value,
                    onCheckedChange = {
                        maleCheckboxValue.value = it
                        if (it) {
                            femaleCheckboxValue.value = false
                            fixedText.value = "Your gender is male"
                        } else {
                            fixedText.value = "Select Your Gender"
                        }
                    },
                    colors = CheckboxDefaults.colors(Color(myColor))
                )

                Text(
                    text = "Male",
                    color = Color.White
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = femaleCheckboxValue.value,
                    onCheckedChange = {
                        femaleCheckboxValue.value = it
                        if (it) {
                            maleCheckboxValue.value = false
                            fixedText.value = "Your gender is female"
                        } else {
                            fixedText.value = "Select Your Gender"
                        }
                    },
                    colors = CheckboxDefaults.colors(Color(myColor))
                )

                Text(
                    text = "Female",
                    color = Color.White
                )
            }
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