package com.example.login_out

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Sign_Up : AppCompatActivity() {
    private lateinit var edName:EditText
    private lateinit var edMobile:EditText
    private lateinit var edLocation:EditText
    private lateinit var edPassword:EditText
    private lateinit var btnSubmit:Button

    private lateinit var db:DBH

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        db= DBH(this)

        edName=findViewById(R.id.edName)
        edMobile=findViewById(R.id.edMobile)
        edLocation=findViewById(R.id.edLocation)
        edPassword=findViewById(R.id.edPW)

        btnSubmit=findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            postUser()
        }
    }
    private fun postUser() {
        val name1 = edName.text.toString()
        val mobile1=edMobile.text.toString()
        val location1=edLocation.text.toString()
        val password1=edPassword.text.toString()
        db.addUser(User(0,name1,mobile1,location1,password1))
        Toast.makeText(this,"SAVED",Toast.LENGTH_LONG).show()
        val int = Intent(this,Welcome::class.java)
        int.putExtra("Name1",name1)
        int.putExtra("Mobile1",mobile1)
        int.putExtra("Location1",location1)
        int.putExtra("Password1",password1)
        startActivity(int)


    }
}