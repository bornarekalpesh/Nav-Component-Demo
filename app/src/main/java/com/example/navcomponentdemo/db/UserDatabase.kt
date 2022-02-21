package com.example.navcomponentdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.navcomponentdemo.model.Data

@Database(entities = [Data::class], version = 1)
abstract class UserDatabase:RoomDatabase() {

    abstract fun userDao():UserDao

    companion object{
        @Volatile
        private var instance:UserDatabase?=null

        fun getDatabase(context:Context):UserDatabase{
            if(instance==null){
                synchronized(this){
                    instance= Room.databaseBuilder(context,
                        UserDatabase::class.java,
                        "userDb").
                     build()
                }
            }
            return instance!!
        }

    }
}