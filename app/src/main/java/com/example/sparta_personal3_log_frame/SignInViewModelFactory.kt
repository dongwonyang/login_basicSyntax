package com.example.sparta_personal3_log_frame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignInViewModelFactory :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SingInViewModel::class.java)){
            return SingInViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}