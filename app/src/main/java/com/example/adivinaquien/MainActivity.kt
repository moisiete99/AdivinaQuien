package com.example.adivinaquien

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var btnvs2: ImageButton
    lateinit var btnClasificacion: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //quitamos title Bar
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) //forzamos orientacion horizontal
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        supportActionBar?.hide()

        btnvs2 = findViewById(R.id.btnVS2)
        btnClasificacion = findViewById(R.id.btnClasificacion)

        btnvs2.setOnClickListener {
            println("Iniciando 2vs2")
            iniciarJuego2()
        }

        btnClasificacion.setOnClickListener {
            println("Iniciando clasificaciones")
            iniciarClasificacion()
        }
    }

    fun iniciarJuego2() {
        val i = Intent(this, Entredos::class.java)
        startActivity(i)
    }

    fun iniciarClasificacion() {
        val i = Intent(this, ClasificacionActivity::class.java)
        startActivity(i)
    }
}