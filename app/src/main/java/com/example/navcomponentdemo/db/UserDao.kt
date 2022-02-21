package com.example.navcomponentdemo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.navcomponentdemo.model.Data

@Dao
interface UserDao {
    @Insert
    fun adduser(data: List<Data>)

    @Query("Select * from userlist")
    fun getUserList():List<Data>
}