package com.example.testprojectusecase.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    init {
        Log.e("AAA", "VW created")
    }

    override fun onCleared() {
        Log.e("AAA", "VW cleared")
        super.onCleared()
    }
}