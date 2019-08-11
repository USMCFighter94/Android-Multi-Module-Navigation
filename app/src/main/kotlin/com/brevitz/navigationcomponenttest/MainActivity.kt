package com.brevitz.navigationcomponenttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationUI.setupWithNavController(bottomNavView, findNavController(R.id.navHostFragment))
    }

    override fun onSupportNavigateUp() = findNavController(R.id.navHostFragment).navigateUp()
}
