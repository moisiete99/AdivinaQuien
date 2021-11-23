package com.example.adivinaquien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LogIn : AppCompatActivity() {

    lateinit var edtEmail:EditText
    lateinit var edtPassword:EditText
    lateinit var btnLogin: Button
    lateinit var btnSignup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        edtEmail=findViewById(R.id.edt_email)
        edtPassword=findViewById(R.id.edt_password)
        btnLogin=findViewById(R.id.btn_login)
        btnSignup=findViewById(R.id.btn_signup)

        btnSignup.setOnClickListener{
            val i = Intent(this, SignUp::class.java)
            startActivity(i)
        }
    }
}