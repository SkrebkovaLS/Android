package com.example.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            val cal = Calendar.getInstance()
            val intent = Intent(this,MyAlarmReciver::class.java)
            val rcode = Random().nextInt()
            intent.putExtra("REQUEST_CODE",rcode)
            val pendingIntent = PendingIntent.getBroadcast(this,rcode,intent,0)
            intent.addFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES)
            intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
                Toast.makeText(this, "Будильник сработает в "+SimpleDateFormat("HH:mm").format(cal.time),Toast.LENGTH_LONG).show()
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.timeInMillis,pendingIntent)
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
    }
}