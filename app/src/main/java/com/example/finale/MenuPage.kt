package com.example.finale

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.finale.view.EventView
import com.example.finale.view.JobView
import com.example.finale.view.TutorialView
import com.google.firebase.auth.FirebaseAuth

class MenuPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_page)

        val jobButton = findViewById<Button>(R.id.job_list_button)
        jobButton.setOnClickListener{
            val intent = Intent(this, JobView::class.java)
            startActivity(intent)
        }

        val tutorialButton = findViewById<Button>(R.id.tutorial_button)
        tutorialButton.setOnClickListener{
            val intent = Intent(this, TutorialView::class.java)
            startActivity(intent)
        }

        val eventButton = findViewById<Button>(R.id.events_button)
        eventButton.setOnClickListener{
            val intent = Intent(this, EventView::class.java)
            startActivity(intent)
        }

        // Declare the switch from the layout file
        val switchBtn = findViewById<Switch>(R.id.switch1)

        // set the switch to listen on checked change
        switchBtn.setOnCheckedChangeListener { _, isChecked ->

            // if the button is checked, i.e., towards the right or enabled
            // enable dark mode, change the text to disable dark mode
            // else keep the switch text to enable dark mode
            if (switchBtn.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switchBtn.text = "Disable dark mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchBtn.text = "Enable dark mode"
            }
        }

        val logoutBtn = findViewById<Button>(R.id.logout)

        logoutBtn.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@MenuPage, MainActivity::class.java))
            finish()
        }
    }
}