package com.example.login_out

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignIn : AppCompatActivity() {

    private lateinit var edN:EditText
    private lateinit var edP:EditText
    private lateinit var btnS:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        edN=findViewById(R.id.edN)
        edP=findViewById(R.id.edP)
        btnS=findViewById(R.id.btnS)
        btnS.setOnClickListener {
            val name2=edN.text.toString()
            val password2=edP.text.toString()
            val int =Intent(this,Details::class.java)
            int.putExtra("name2",name2)
            int.putExtra("password2",password2)
            startActivity(int)
        }
    }
}