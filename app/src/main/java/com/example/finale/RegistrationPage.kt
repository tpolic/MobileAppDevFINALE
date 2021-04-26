package com.example.finale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistrationPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)
        val button2 = findViewById<Button>(R.id.button_signIn)
        button2.setOnClickListener{
            val intent = Intent(this, MenuPage::class.java)
            startActivity(intent)
        }
    }
}