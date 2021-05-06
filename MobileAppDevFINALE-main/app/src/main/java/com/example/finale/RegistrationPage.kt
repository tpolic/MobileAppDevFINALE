package com.example.finale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class RegistrationPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)
        val button2 = findViewById<Button>(R.id.button_signUp)
        button2.setOnClickListener{
            //val intent = Intent(this, MenuPage::class.java)
            //startActivity(intent)
            when{
                /*TextUtils.isEmpty(R.id.nameRegistration.toString().trim {it <= ' '}) -> {
                    Toast.makeText(
                        this@RegistrationPage,
                        "Please enter name.",
                        Toast.LENGTH_SHORT
                    ).show()
                }*/

                TextUtils.isEmpty(findViewById<EditText>(R.id.editTextEmailAddressSignUp).text.toString().trim {it <= ' '}) -> {
                    Toast.makeText(
                        this@RegistrationPage,
                        "Please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(findViewById<EditText>(R.id.editTextPasswordSignUp).text.toString().trim {it <= ' '}) -> {
                    Toast.makeText(
                        this@RegistrationPage,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = findViewById<EditText>(R.id.editTextEmailAddressSignUp).text.toString().trim {it <= ' '}
                    val password: String = findViewById<EditText>(R.id.editTextPasswordSignUp).text.toString().trim {it <= ' '}
                    println("test123password ${password}")
                    println("test123email ${email}")

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> {task ->
                                if(task.isSuccessful){
                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@RegistrationPage,
                                        "You are registered successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent =
                                        Intent(this@RegistrationPage, MainActivity::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id", firebaseUser.uid)
                                    intent.putExtra("email_id", email)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this@RegistrationPage,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        )

                }
            }

        }
    }
}