package com.example.workoutapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WorkOutViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorkOutViewModel() as T
    }
}