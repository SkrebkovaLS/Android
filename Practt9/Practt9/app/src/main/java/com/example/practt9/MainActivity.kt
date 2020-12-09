package com.example.practt9

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    val btn_login = findViewById<Button>(R.id.btn_l)
    val btn_signup = findViewById<Button>(R.id.btn_s)
    val edt_login = findViewById<EditText>(R.id.edt_l)
    val edt_password = findViewById<EditText>(R.id.edt_p)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        auth = FirebaseAuth.getInstance()

        btn_signup.setOnClickListener{
            signInUser()
        }

        btn_login.setOnClickListener{
            signInUser()
        }
    }

    private fun signInUser(){
        auth.signInWithEmailAndPassword(edt_login.text.toString(),edt_password.text.toString())
            .addOnCompleteListener(this) {task->
                if (task.isSuccessful){
                    Toast.makeText(baseContext,"Пользователь зарегистрирован",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(baseContext,task.exception.toString(),Toast.LENGTH_SHORT).show()
                    Log.i("ff",task.exception.toString())
                }
            }
    }
}