package com.example.adivinaquien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnvs2 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entredos)

        /*btnvs2 = findViewById(R.id.btnVS2)
        btnvs2.setOnClickListener{
            println("Iniciando 2vs2")
            iniciarJuego2()
        }*/
    }

    fun iniciarJuego2(){
        val i = Intent(this,Entredos::class.java)
        startActivity(i)
    }
}