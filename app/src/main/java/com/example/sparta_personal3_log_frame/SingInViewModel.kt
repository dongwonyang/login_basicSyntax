package com.example.sparta_personal3_log_frame

import androidx.lifecycle.ViewModel

class SingInViewModel : ViewModel() {
    fun isUsernameValid(username: String) : Boolean{
        return username.length > 5
    }
    fun isPasswordValid(password : String) : Boolean{
        return password.length > 5
    }
}