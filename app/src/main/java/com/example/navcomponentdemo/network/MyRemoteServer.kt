package com.example.navcomponentdemo.network

import com.example.navcomponentdemo.model.TestingData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyRemoteServer {

    @GET("api/users")
    suspend fun getUserList(@Query("page") page: Int): Response<TestingData>
}