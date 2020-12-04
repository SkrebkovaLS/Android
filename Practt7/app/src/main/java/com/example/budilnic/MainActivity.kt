package com.example.budilnic

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var peopleDB: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnShow = findViewById<Button>(R.id.btnShow)

        peopleDB = DatabaseHelper(this@MainActivity);

        btnAdd.setOnClickListener {
            addUser()
        }

        btnShow.setOnClickListener{
            showUsers()
        }
    }
    private fun addUser() {
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val name: String = edtName.text.toString()
        val email: String = edtEmail.text.toString()

        val insertData: Boolean = peopleDB!!.addData(name, email)

        if (insertData == true) {
            Toast.makeText(this@MainActivity, "Запись добавлена!", Toast.LENGTH_LONG)
                    .show()
        } else {
            Toast.makeText(this@MainActivity, "Что-то пошло не так!" , Toast.LENGTH_LONG).show()
        }
    }
    private fun showUsers(){
        val data: Cursor? = peopleDB!!.showData()

        if(data!!.getCount() == 0 ){
            display("Error", "Нет данных.")
            return
        }
        val buffer = StringBuffer()
        while (data.moveToNext()){
            buffer.append(
                    "ID:" + data.getString(0) + "\n"
            )
            buffer.append(
                    "Name:" +data.getString(1) + "\n"
            )
            buffer.append(
                    "Email:" +data.getString(2) + "\n"
            )
            display("Все пользователи", buffer.toString())
        }
    }

    fun display (title: String?, message: String?){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.show()
    }
}