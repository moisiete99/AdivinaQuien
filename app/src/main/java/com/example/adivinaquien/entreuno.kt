package com.example.adivinaquien

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Chronometer
import com.example.adivinaquien.databinding.ActivityMainBinding

class entreuno : AppCompatActivity() {

    //Cronometro
    private lateinit var btnIniciar: Button
    private lateinit var cronometro: Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Pantalla completa
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //quitamos title Bar
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) //forzamos orientacion horizontal

        setContentView(R.layout.activity_entreuno)

        //Cronometro
        btnIniciar = findViewById(R.id.btnIniciar)
        cronometro = findViewById(R.id.cronometro)
        btnIniciar.setOnClickListener {
            cronometro.base = SystemClock.elapsedRealtime()
            cronometro.start()
            btnIniciar.setVisibility(View.GONE)
        }
    }
}