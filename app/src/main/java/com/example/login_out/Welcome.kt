package com.example.login_out

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Welcome : AppCompatActivity() {
    private lateinit var tvUserName: TextView
    private lateinit var tvUserData: TextView

    private lateinit var btnOut: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        tvUserName=findViewById(R.id.tvUserName)
        tvUserData=findViewById(R.id.tvUserData)

        val i = intent

        val name = i.getStringExtra("Name1")
        val mobile=i.getStringExtra("Mobile1")
        val location=i.getStringExtra("Location1")
        val password=i.getStringExtra("Password1")

        tvUserName.text = "Welcome $name ,"
        tvUserData.text = "your details are ,\n Name: $name \n Mobile: $mobile \n Location: $location \n Password: $password"

        btnOut=findViewById(R.id.btnOut)
        btnOut.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }
}