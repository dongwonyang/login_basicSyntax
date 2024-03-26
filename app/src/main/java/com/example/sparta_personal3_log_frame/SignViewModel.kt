package com.example.sparta_personal3_log_frame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignViewModel : ViewModel() {
    private val _userAccount = MutableLiveData<AccountInfo>()

    val userAccount: LiveData<AccountInfo> = _userAccount

    init {
        _userAccount.value = AccountInfo("","","")
    }
    fun inputName(userName: String){
       _userAccount.value?.name = userName
    }
    fun inputId(id: String){
        if(isEmailValid(id)) _userAccount.value?.id = id
    }
    fun inputPw(pw: String){
        if(isPasswordValid(pw)) _userAccount.value?.pw = pw
    }

    fun isAccountValid(): Boolean{
        return (userAccount.value?.name?.isNotEmpty() ?: false
                && userAccount.value?.id?.isNotEmpty() ?: false
                && userAccount.value?.pw?.isNotEmpty() ?: false)
    }

    fun getAccount(): Pair<String, String>?{
        return Pair(userAccount.value?.id ?:"", userAccount.value?.pw ?:"")
    }

    fun getName(): String?{
        return userAccount.value?.name
    }

    fun getId(): String?{
        return userAccount.value?.id
    }
    fun getPw(): String?{
        return userAccount.value?.pw
    }
    private fun isEmailValid(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    private fun isPasswordValid(password : String) : Boolean{
        return password.length > 5
    }
}