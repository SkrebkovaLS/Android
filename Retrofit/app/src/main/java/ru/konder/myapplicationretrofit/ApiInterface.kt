package ru.konder.myapplicationretrofit

import ru.konder.myapplicationretrofit.Models.UrlImageModels
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterfaces {
    @GET("meow")
    fun getFiles(): Call<UrlImageModels>
}