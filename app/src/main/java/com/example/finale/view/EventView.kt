package com.example.finale.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finale.R

class EventView: AppCompatActivity()  {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_view);

        navController = findNavControllerWorkaround2(R.id.navHostEvent)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}

fun AppCompatActivity.findNavControllerWorkaround2(resId: Int): NavController {
    return (supportFragmentManager.findFragmentById(resId) as NavHost).navController
}