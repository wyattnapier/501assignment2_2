package com.example.assign2_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assign2_2.ui.theme.Assign2_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assign2_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ToggleCard(
                        name = "Android",
                        modifier = Modifier.fillMaxWidth().padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ToggleCard(name: String, modifier: Modifier = Modifier) {
    var clicked by remember { mutableStateOf(false) }
    val greeting = if (clicked) "Hello" else "Goodbye"
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            onClick = { clicked = !clicked },
            modifier = modifier.padding(16.dp)
        ) {
            Text(
                text = "$greeting $name!",
                modifier = modifier.padding(24.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true) // static preview
@Composable
fun ToggleCardPreview() {
    Assign2_2Theme {
        ToggleCard(name = "Android")
    }
}
