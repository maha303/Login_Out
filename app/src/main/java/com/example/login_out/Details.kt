package com.example.login_out

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Details : AppCompatActivity() {

    private lateinit var tvUserName2:TextView
    private lateinit var tvUserData2:TextView
    private lateinit var btnOut:Button
    private lateinit var db:DBH

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        db= DBH(this)

        tvUserName2=findViewById(R.id.tvUserName2)
        tvUserData2=findViewById(R.id.tvUserData2)

        val i = intent

        val name2=i.getStringExtra("name2")
        val loc = db.getdata(name2.toString())
        tvUserName2.text = "Welcome back  $name2 \n Your data is : "
        tvUserData2.text = loc
        btnOut=findViewById(R.id.btnOut)
        btnOut.setOnClickListener {
            db.Delete1(name2.toString())
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
}}