package com.example.mvvmsqllite.viewmodel

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsqllite.LoginResultCallBacks
import com.example.mvvmsqllite.model.User

class LoginViewModel (private val listener: LoginResultCallBacks): ViewModel(){
    private val user: User

    init {
        this.user = User("", "")
    }
    val emailTextWatcher: TextWatcher
    get() = object:TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            user.setEmail(s.toString())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }
    }
    fun onLoginClicked(View){
        if (user.isDataValid)
            listener.onSuccess("Успешно авторизовался")
        else
            listener.onError("Произошла ошибка")
    }
    class LoginViewModelFactory(private val listener: LoginResultCallBacks): ViewModelProvider.NewInstanceFactory()


}