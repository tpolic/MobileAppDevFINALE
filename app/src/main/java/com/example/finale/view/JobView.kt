package com.example.finale.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.example.finale.R
import com.example.finale.RegistrationPage

class JobView : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.job_view)

        navController = findNavControllerWorkaround(R.id.navHost)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
    fun AppCompatActivity.findNavControllerWorkaround(resId: Int): NavController {
        return (supportFragmentManager.findFragmentById(resId) as NavHost).navController
    }
}