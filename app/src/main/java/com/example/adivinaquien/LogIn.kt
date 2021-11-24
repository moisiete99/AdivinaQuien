package com.example.adivinaquien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LogIn : AppCompatActivity() {

    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogin: Button
    lateinit var btnSignup: Button
    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        mAuth = FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btn_login)
        btnSignup = findViewById(R.id.btn_signup)

        btnSignup.setOnClickListener {
            val i = Intent(this, SignUp::class.java)
            startActivity(i)
        }

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            login(email,password)

            //LLamar al menu de opciones de juego
            /*val i = Intent(this, MainActivity::class.java)
            startActivity(i)*/
        }
    }

    private fun login(email: String, password: String) {
        //logeo de usuario
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@LogIn, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LogIn, "Usuario no existente", Toast.LENGTH_SHORT).show()
                }
            }
    }
}