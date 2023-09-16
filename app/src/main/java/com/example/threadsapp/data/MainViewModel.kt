package com.example.threadsapp.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var isDialogShown by mutableStateOf(false)


    fun onDismissDialog(){

        isDialogShown = false
    }
}