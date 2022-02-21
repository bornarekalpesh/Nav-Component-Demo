package com.example.navcomponentdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userlist")
data class User (
    @PrimaryKey(autoGenerate = true)
    val userid: Int,
    var avatar: String,
    var email: String,
    var first_name: String,
    var id: Int,
    val last_name: String
)