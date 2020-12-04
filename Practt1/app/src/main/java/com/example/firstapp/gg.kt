package com.example.firstapp

import android.net.Uri
import okhttp3.*
import java.io.IOException
import okhttp3.RequestBody


class gg (){
    private val okHttpClient = OkHttpClient.Builder().build()
    fun fts(url:String): Response{
            return okHttpClient.newCall(Request.Builder().url(url).build()).execute()
    }
}