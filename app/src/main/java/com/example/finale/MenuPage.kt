package com.example.finale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.finale.view.JobView

class MenuPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_page)

        val button = findViewById<Button>(R.id.job_list_button)
        button.setOnClickListener{
            val intent = Intent(this, JobView::class.java)
            startActivity(intent)
        }
    }
}