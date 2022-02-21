package com.example.navcomponentdemo.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.navcomponentdemo.db.UserDatabase
import com.example.navcomponentdemo.model.TestingData
import com.example.navcomponentdemo.network.MyRemoteServer
import com.example.navcomponentdemo.utils.NetworkUtils

class UserRepository(
    private val myRemoteServer: MyRemoteServer,
    private val userDatabase: UserDatabase,
    private val applicationContext: Context
) {

    private val userListLiveData=MutableLiveData<TestingData>()
    val userList:LiveData<TestingData>
    get() = userListLiveData

    suspend fun getUserList(page:Int){

        if(NetworkUtils.isOnline(applicationContext)){
            var result= myRemoteServer.getUserList(page)
            if(result?.body()!==null){
                userDatabase.userDao().adduser(result.body()!!.data)
                userListLiveData.postValue(result.body())
            }
        }
        else{
            val userData=userDatabase.userDao().getUserList()
            val userList=TestingData(userData,1,1,1,1)
            userListLiveData.postValue(userList)
        }

    }
}