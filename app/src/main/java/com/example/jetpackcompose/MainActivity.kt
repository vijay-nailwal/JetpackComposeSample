package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcompose.components.CountryInfoAppScaffold
import com.example.jetpackcompose.data.Country
import com.example.jetpackcompose.ui.theme.MyCustomAppTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"
    private lateinit var countryList: MutableList<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCustomAppTheme {
                CountryInfoAppScaffold()
            }
        }
    }
}
