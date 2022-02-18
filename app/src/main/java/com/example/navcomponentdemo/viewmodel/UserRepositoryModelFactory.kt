package com.example.navcomponentdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.navcomponentdemo.repository.UserRepository

class UserRepositoryModelFactory(private val userRepository: UserRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return UserRepositoryViewModel(userRepository) as T
    }
}