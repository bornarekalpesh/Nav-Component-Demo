package com.example.navcomponentdemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.navcomponentdemo.model.TestingData
import com.example.navcomponentdemo.network.ApiHelper
import com.example.navcomponentdemo.network.MyRemoteServer

class UserRepository(private val myRemoteServer: MyRemoteServer) {

    private val userListLiveData=MutableLiveData<TestingData>()
    val userList:LiveData<TestingData>
    get() = userListLiveData

    suspend fun getUserList(page:Int){
        var result= myRemoteServer.getUserList(page)

        if(result?.body()!==null){
            userListLiveData.postValue(result.body())
        }
    }
}