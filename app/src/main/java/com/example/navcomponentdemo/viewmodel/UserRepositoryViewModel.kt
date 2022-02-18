package com.example.navcomponentdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navcomponentdemo.model.TestingData
import com.example.navcomponentdemo.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepositoryViewModel(private val userRepository: UserRepository):ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO){
            userRepository.getUserList(1)
        }
    }
    val userList:LiveData<TestingData>
    get() = userRepository.userList

}