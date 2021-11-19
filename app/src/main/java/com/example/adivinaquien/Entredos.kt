package com.example.adivinaquien

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.PersistableBundle
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Entredos : Activity() {

    //img's
    var img01 : ImageButton = findViewById(R.id.btn01)
    var img02 : ImageButton = findViewById(R.id.btn02)
    var img03 : ImageButton = findViewById(R.id.btn03)
    var img04 : ImageButton = findViewById(R.id.btn04)
    var img05 : ImageButton = findViewById(R.id.btn05)
    var img06 : ImageButton = findViewById(R.id.btn06)
    var img07 : ImageButton = findViewById(R.id.btn07)
    var img08 : ImageButton = findViewById(R.id.btn08)
    var img09 : ImageButton = findViewById(R.id.btn09)
    var img10 : ImageButton = findViewById(R.id.btn10)
    var img11 : ImageButton = findViewById(R.id.btn11)
    var img12 : ImageButton = findViewById(R.id.btn12)
    var img13 : ImageButton = findViewById(R.id.btn13)
    var img14 : ImageButton = findViewById(R.id.btn14)
    var img15 : ImageButton = findViewById(R.id.btn15)
    var img16 : ImageButton = findViewById(R.id.btn16)
    var img17 : ImageButton = findViewById(R.id.btn17)
    var img18 : ImageButton = findViewById(R.id.btn18)
    var img19 : ImageButton = findViewById(R.id.btn19)
    var img20 : ImageButton = findViewById(R.id.btn20)
    var img21 : ImageButton = findViewById(R.id.btn21)
    var img22 : ImageButton = findViewById(R.id.btn22)
    var img23 : ImageButton = findViewById(R.id.btn23)
    var img24 : ImageButton = findViewById(R.id.btn24)

    //lateinit var tablero : ImageButton

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        //super.onCreate(savedInstanceState, persistentState)
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        //this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //setContentView(R.layout.activity_main)

        val tablero = arrayOf<ImageButton>(
            img01,img02,img03,img04,img05,img06,img07,img08,
            img09,img10,img11,img12,img13,img14,img15,img16,
            img17,img18,img19,img20,img21,img22,img23,img24)
    }
}