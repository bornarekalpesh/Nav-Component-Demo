package com.example.navcomponentdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navcomponentdemo.adapter.UserAdapter
import com.example.navcomponentdemo.databinding.FragmentFeaturedBinding
import com.example.navcomponentdemo.model.TestingData
import com.example.navcomponentdemo.network.ApiHelper
import com.example.navcomponentdemo.network.MyRemoteServer
import com.example.navcomponentdemo.repository.UserRepository
import com.example.navcomponentdemo.viewmodel.UserRepositoryModelFactory
import com.example.navcomponentdemo.viewmodel.UserRepositoryViewModel

class FeaturedFragment : Fragment() {

   lateinit var  binding: FragmentFeaturedBinding

   lateinit var userRepository:UserRepositoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil
            .inflate(inflater, R.layout.fragment_featured, container, false)


        val userList=ApiHelper.getInstance().create(MyRemoteServer::class.java)

        val respository=UserRepository(userList)

        userRepository=ViewModelProvider(this,UserRepositoryModelFactory(respository)).get(UserRepositoryViewModel::class.java)

        userRepository.userList.observe(viewLifecycleOwner) {
            Log.e("API_RESPONSE", it.toString())

        }
        val userAdapter=UserAdapter()

        binding.featuredFragmentRv.layoutManager=LinearLayoutManager(activity)
        binding.featuredFragmentRv.adapter=userAdapter


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding
    }

}