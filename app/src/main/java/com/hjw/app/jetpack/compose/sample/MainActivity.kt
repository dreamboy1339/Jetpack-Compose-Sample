package com.hjw.app.jetpack.compose.sample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.app.jetpack.compose.sample.ui.theme.JetpackComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
                var currentScreen by remember { mutableStateOf(1) }

                when (currentScreen) {
                    1 -> ScreenOne(
                        onGoToScreenTwo = { currentScreen = 2 },
                        onGoToScreenThree = {
                            startActivity(Intent(this, SecondActivity::class.java))
                        }
                    )
                    2 -> ScreenTwo()
                }
            }
        }
    }
}

@Composable
fun ScreenOne(
    onGoToScreenTwo: () -> Unit,
    onGoToScreenThree: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onGoToScreenTwo) {
            Text("Go to Screen 2")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onGoToScreenThree) {
            Text("Go to Screen 3")
        }
    }
}

@Composable
fun ScreenTwo() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("This is Screen 2")
    }
}
