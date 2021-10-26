package com.example.login_out

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnSignIn:Button
    private lateinit var btnSingUp:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignIn=findViewById(R.id.btnSignIn)
        btnSignIn.setOnClickListener {
            val int = Intent(this,SignIn::class.java)
            startActivity(int)

        }

        btnSingUp=findViewById(R.id.btnSignUp)
        btnSingUp.setOnClickListener {
            val int = Intent(this,Sign_Up::class.java)
            startActivity(int)
        }
    }
}