package com.example.navcomponentdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userlist")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val userid: Int,
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)