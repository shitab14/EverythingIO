package com.shitabmir.everythingio.presentation.buttonpage

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ButtonElevation
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shitabmir.everythingio.presentation.buttonpage.ui.theme.EverythingIOTheme

class ButtonsComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        receiveDataFromIntent()

        setContent {
            EverythingIOTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    private fun receiveDataFromIntent() {
        // Receiving activity
         val receivedData = intent.getStringExtra("key")
        Toast.makeText(this, receivedData, Toast.LENGTH_LONG).show()
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val buttonColor1 by remember { mutableStateOf(Color.Red) }
    Column(

    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(
            content = {
                Text(text = "d")
            },
            onClick = { /*TODO*/ },
            colors = ButtonColors(
                containerColor = buttonColor1,
                disabledContainerColor = Color.Gray,
                contentColor = Color.White,
                disabledContentColor = Color.White,
            ),
            enabled = true,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EverythingIOTheme {
        Greeting("Android")
    }
}