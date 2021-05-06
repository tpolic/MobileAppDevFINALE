package com.example.finale

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonRegistration)
        button.setOnClickListener{
           // val intent = Intent(this, RegistrationPage::class.java)
            val intent = Intent(this, MenuPage::class.java)

            startActivity(intent)
        }
        val buttonLogin = findViewById<Button>(R.id.loginButton)
        buttonLogin.setOnClickListener{
            when{

                TextUtils.isEmpty(findViewById<EditText>(R.id.editTextEmailAddress).text.toString().trim {it <= ' '}) -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(findViewById<EditText>(R.id.editTextEmailAddress).text.toString().trim {it <= ' '}) -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = findViewById<EditText>(R.id.editTextEmailAddress).text.toString().trim {it <= ' '}
                    val password: String = findViewById<EditText>(R.id.editTextPassword).text.toString().trim {it <= ' '}

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener {task ->
                            if(task.isSuccessful){

                                Toast.makeText(
                                    this@MainActivity,
                                    "You are logged in successfully",
                                    Toast.LENGTH_SHORT
                                ).show()


                                val intent =
                                    Intent(this@MainActivity, MenuPage::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@MainActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
    }

}