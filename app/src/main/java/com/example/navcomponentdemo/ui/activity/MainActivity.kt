package com.example.navcomponentdemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.navcomponentdemo.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val navController=Navigation.findNavController(this, R.id.nav_host_fragment)
        findViewById<BottomNavigationView>(R.id.bottom_nav)?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

}