package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"
    private val mainActivityViewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(mainActivityViewModel)
        }
    }

    @Composable
    private fun MainScreen(mainActivityViewModel: MainActivityViewModel?) {

        mainActivityViewModel?.counter?.observeAsState()?.value
        mainActivityViewModel?.error?.observeAsState()?.value?.let {
            Toast.makeText(LocalContext.current,it.toString(),Toast.LENGTH_SHORT).show()
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(2.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { mainActivityViewModel?.decrementCounter?.invoke() },
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Decrement")
                }

                Text(text = "${mainActivityViewModel?.counter?.value} ")

                Button(
                    onClick = { mainActivityViewModel?.incrementCounter?.invoke() },
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Increment")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MainScreen(null)
    }
}

