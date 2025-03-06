package com.example.jetpackcompose

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val TAG = "MainActivityViewModel"
    var counter = MutableLiveData<Int>(0)
    var error = MutableLiveData<String>()

    var incrementCounter = {
        counter.value = counter.value?.plus(1)
    }
    var decrementCounter = {
        if (counter.value == 0) {
            if (error.value == null) {
                error.value = "counter cannot be less than 0"
            }
        }  else {
            Log.d(TAG, ": counter value is ${counter}")
            counter.value = counter.value?.minus(1)

        }
    }
}