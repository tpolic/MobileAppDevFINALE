package com.example.finale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.finale.view.JobView
import com.example.finale.view.TutorialView

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
    }
}