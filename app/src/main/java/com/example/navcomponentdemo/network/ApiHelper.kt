package com.example.navcomponentdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiHelper {

    private val basrUrl="https://reqres.in/"

    fun getInstance(): Retrofit {
     return Retrofit.Builder()
            .baseUrl(basrUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}