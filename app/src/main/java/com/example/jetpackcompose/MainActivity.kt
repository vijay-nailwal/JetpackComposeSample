package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.components.CountryCardWithConstraintLayout
import com.example.jetpackcompose.data.CountryInfo
import com.example.jetpackcompose.data.getCountryList
import com.example.jetpackcompose.ui.theme.CountryInfoAppTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen("vijay")
        }
    }
}

@Composable
fun MainScreen(name: String, modifier: Modifier = Modifier) {

    //in modifier sequence important
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "hello $name",
            modifier = Modifier.width(200.dp).height(100.dp).border(1.dp, Color.Blue)
                .background(Color.LightGray)
                .clickable { Log.d("MainActivity", "MainScreen: clicked") }.padding(10.dp)
                .clip(RoundedCornerShape(5.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen("vijay")
}