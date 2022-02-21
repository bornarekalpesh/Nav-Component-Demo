package com.example.navcomponentdemo

import android.app.Application
import com.example.navcomponentdemo.db.UserDatabase
import com.example.navcomponentdemo.network.ApiHelper
import com.example.navcomponentdemo.network.MyRemoteServer
import com.example.navcomponentdemo.repository.UserRepository

class NavApplication:Application(){
    lateinit var userRepository: UserRepository
    override fun onCreate() {
        super.onCreate()
        inistizled()
    }

    private fun inistizled() {

        val userList= ApiHelper.getInstance().create(MyRemoteServer::class.java)
        val datbase=UserDatabase.getDatabase(applicationContext)
        userRepository=UserRepository(userList,datbase,applicationContext)

    }
}