package com.example.navcomponentdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.navcomponentdemo.R
import com.example.navcomponentdemo.databinding.ItemUserListBinding
import com.example.navcomponentdemo.model.User
import com.squareup.picasso.Picasso

class UserAdapter: ListAdapter<User, UserAdapter.UserAdapaterViewholder>(DiffUtil()) {

    lateinit var binding:ItemUserListBinding
    private var user: User? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapaterViewholder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding=DataBindingUtil
            .inflate(layoutInflater, R.layout.item_user_list, parent, false)


        return UserAdapaterViewholder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapaterViewholder, position: Int) {
//        var testingData:TestingData=TestingData().data[position].
////        user?.first_name=getItem(position).first_name+getItem(position).last_name
////        user?.email=getItem(position).email
////        user?.id=getItem(position).id
////        user?.avatar=getItem(position).avatar
////        binding.userData=user

        binding.tvEmail.text=getItem(position).email
        binding.tvName.text=getItem(position).first_name+getItem(position).last_name
        binding.tvId.text=getItem(position).id.toString()
        Picasso.get()
            .load(getItem(position).avatar)
            .into(binding.profileImage);
    }

    class UserAdapaterViewholder(val binding: ViewDataBinding):RecyclerView.ViewHolder(binding.root){

    }

    class DiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem==newItem
        }

    }
}