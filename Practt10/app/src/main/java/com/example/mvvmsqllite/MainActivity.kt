package com.example.mvvmsqllite


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsqllite.LoginResultCallBacks
import com.example.mvvmsqllite.databinding.ActivityMainBinding
import com.example.mvvmsqllite.model.User
import com.example.mvvmsqllite.viewmodel.LoginViewModel
import com.example.mvvmsqllite.viewmodel.LoginViewModelFactory

class MainActivity : AppCompatActivity(), LoginResultCallBacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewmodel = ViewModelProvider.of(this,
            LoginViewModel.LoginViewModelFactory(this))
            .get(LoginViewModel::class.java)
    }

    override fun onSuccess(massage:String){
        Toast.makeText(this,massage, Toast.LENGTH_LONG).show()
    }
    override fun onError(massage: String){
        Toast.makeText(this,massage, Toast.LENGTH_LONG).show()
    }
}