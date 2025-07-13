package com.example.intentsdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.intentsdemo.ui.theme.IntentsDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntentsDemoTheme {

                var name = remember { mutableStateOf("") }
                val nameKey = stringResource(id = R.string.nameKey)
                Scaffold(
                    topBar = {
                        title = stringResource(id = R.string.topBar)
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        OutlinedTextField(
                            value = name.value,
                            onValueChange = {
                                name.value = it
                            },
                            label = {
                                Text(text = stringResource(id = R.string.name))
                            }
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(
                            onClick = {
                                val intent = Intent(
                                    this@MainActivity,
                                    MainActivity2::class.java
                                )
                                intent.putExtra(nameKey, name.value)
                                startActivity(intent)
                            }
                        ){
                            Text(text = stringResource(id = R.string.done))
                        }
                    }
                }
            }
        }
    }
}

