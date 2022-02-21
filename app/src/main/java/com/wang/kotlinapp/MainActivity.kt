package com.wang.kotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(
            this,
            navController,
            AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_collect,
                R.id.navigation_personal
            ).build()
        )
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}