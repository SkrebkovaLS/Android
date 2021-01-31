package com.example.mvvmsqllite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import  com.example.mvvmsqllite.LoginResultCallBacks


class LoginViewModelFactory (private val listner:LoginResultCallBacks):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listner)as T
    }
}