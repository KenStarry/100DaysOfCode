package com.example.day6

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day6.ui.theme.Day6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day6Theme {

                Column(
                ) {

                    CreateForm(this@MainActivity,"Username")

                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    name = "Form",
    showSystemUi = true
)
@Composable
fun CreateForm(
    context: Context? = null,
    label: String = ""
) {

    var textFieldState by remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF212121)),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 8.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = "Scaffold",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Scaffold(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) { contentPadding ->

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    TextField(
                        value = textFieldState,
                        label = {
                            Text(text = label)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(contentPadding),
                        onValueChange = {
                            textFieldState = it
                        }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(onClick = {
                        Toast.makeText(context, "Hello $textFieldState", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Register")
                    }

                }

            }
        }

    }
}