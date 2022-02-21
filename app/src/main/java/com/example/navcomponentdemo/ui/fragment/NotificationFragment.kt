package com.example.navcomponentdemo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.navcomponentdemo.R
import com.example.navcomponentdemo.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {

    lateinit var binding:FragmentNotificationBinding;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_notification, container, false)


        binding= DataBindingUtil.
          inflate(inflater, R.layout.fragment_notification, container, false)


        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gotoCatogory.setOnClickListener{
            val nextaction= NotificationFragmentDirections.nextaction()
            nextaction.demoValue=20
            Navigation.findNavController(view).navigate(nextaction)
        }
    }
}