package com.example.intentsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.intentsdemo.ui.theme.IntentsDemoTheme

class MainActivity2 : ComponentActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            IntentsDemoTheme {
                val nameKey = stringResource(id = R.string.nameKey)
                val name = intent.getStringExtra(nameKey) ?: stringResource(id = R.string.noName)

                Scaffold(
                    topBar = {
                        title = stringResource(id = R.string.topBar)
                    }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(it),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(text = "Hello $name")
                    }
                }
            }
        }
    }
}