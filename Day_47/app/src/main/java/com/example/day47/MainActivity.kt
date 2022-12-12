package com.example.day47

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.day47.ui.theme.Day47Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day47Theme {

                val context = LocalContext.current

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    //  our button
                    MyButton(
                        onButtonClicked = {
                            //  toast a message
                            Toast.makeText(context, "Hurray!... You clicked me!", Toast.LENGTH_SHORT).show()
                        }
                    )

                }
            }
        }
    }
}

//  our custom button composable
@Composable
fun MyButton(
    onButtonClicked: () -> Unit
) {

    Button(onClick = {
        //  run the function 'onButtonClicked()' once the button gets clicked
        onButtonClicked()
    }) {
        Text(
            text = "Click me!",
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
        )
    }
}