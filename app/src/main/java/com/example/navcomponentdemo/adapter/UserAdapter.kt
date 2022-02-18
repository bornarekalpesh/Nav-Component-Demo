package com.example.navcomponentdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.navcomponentdemo.R
import com.example.navcomponentdemo.databinding.ItemUserListBinding
import com.example.navcomponentdemo.model.Data

class UserAdapter: ListAdapter<Data, UserAdapter.UserAdapaterViewholder>(DiffUtil()) {

    lateinit var binding:ItemUserListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapaterViewholder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding=DataBindingUtil
            .inflate(layoutInflater, R.layout.item_user_list, parent, false)



        return UserAdapaterViewholder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapaterViewholder, position: Int) {
        val item=getItem(position)
    }

    class UserAdapaterViewholder(val binding: ViewDataBinding):RecyclerView.ViewHolder(binding.root){

    }

    class DiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem==newItem
        }

    }
}