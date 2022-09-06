package com.example.viewmodel_livedata1.ui.theme.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    private val _userLogin = MutableLiveData<String>()
    val userLogin : LiveData<String> = _userLogin

    private val _userPassword = MutableLiveData<String>()
    val userPassword : LiveData<String> = _userPassword

    fun onChangeUserLogin(login: String){
          _userLogin.value = login
    }
    fun onChangeUserPassword(password: String){
        _userPassword.value = password
    }

}