package com.example.finale.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.finale.R

class TutorialView  : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tutorial_view);
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}