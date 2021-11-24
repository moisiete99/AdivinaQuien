package com.example.adivinaquien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity() {

    lateinit var edtName: EditText
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnSignup: Button
    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //mAuth = FirebaseAuth.getInstance()
        mAuth = Firebase.auth

        edtName = findViewById(R.id.edt_name)
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnSignup = findViewById(R.id.btn_signup)

        btnSignup.setOnClickListener {
            val email = edtEmail.text.toString()
            val password=edtPassword.text.toString()

            signUp(email,password)
        }
    }

    private fun signUp(email: String, password: String) {
        //logica para crear usuario
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //pasamos al menu
                    val intent = Intent(this@SignUp, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignUp, "Ocurrio un error", Toast.LENGTH_SHORT).show()
                }
            }
    }
}