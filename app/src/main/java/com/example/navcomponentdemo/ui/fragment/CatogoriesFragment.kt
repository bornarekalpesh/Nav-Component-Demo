package com.example.navcomponentdemo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.navcomponentdemo.R
import com.example.navcomponentdemo.databinding.FragmentCatogoriesBinding

class CatogoriesFragment : Fragment() {
    lateinit var binding:FragmentCatogoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil
            .inflate(inflater, R.layout.fragment_catogories, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val safeargs= CatogoriesFragmentArgs.fromBundle(it)
            binding.catergoryDemoValue.text="Test value"+safeargs.demoValue
        }

    }
}