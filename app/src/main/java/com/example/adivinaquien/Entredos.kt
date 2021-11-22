package com.example.adivinaquien

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.collections.ArrayList

class Entredos : AppCompatActivity() {

    ////variables para los componentes
    lateinit var img01 : ImageButton
    lateinit var img02 : ImageButton
    lateinit var img03 : ImageButton
    lateinit var img04 : ImageButton
    lateinit var img05 : ImageButton
    lateinit var img06 : ImageButton
    lateinit var img07 : ImageButton
    lateinit var img08 : ImageButton
    lateinit var img09 : ImageButton
    lateinit var img10 : ImageButton
    lateinit var img11 : ImageButton
    lateinit var img12 : ImageButton
    lateinit var img13 : ImageButton
    lateinit var img14 : ImageButton
    lateinit var img15 : ImageButton
    lateinit var img16 : ImageButton
    lateinit var img17 : ImageButton
    lateinit var img18 : ImageButton
    lateinit var img19 : ImageButton
    lateinit var img20 : ImageButton
    lateinit var img21 : ImageButton
    lateinit var img22 : ImageButton
    lateinit var img23 : ImageButton
    lateinit var img24 : ImageButton
    lateinit var imgPersonaje : ImageButton
    //botones
    lateinit var btnConectar : Button
    lateinit var btnChat : Button

    //variables del juego
    var tablero = arrayListOf<ImageButton>()
    var arrayDesordenado = arrayListOf<Int>()

    //imagenes
    var imagenes = arrayListOf<Int>()
    var fondo : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //quitamos title Bar
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) //forzamos orientacion horizontal
        setContentView(R.layout.entredos)

        init()
    }

    fun cargarTablero() {
        img01 = findViewById(R.id.btn01)
        img02 = findViewById(R.id.btn02)
        img03 = findViewById(R.id.btn03)
        img04 = findViewById(R.id.btn04)
        img05 = findViewById(R.id.btn05)
        img06 = findViewById(R.id.btn06)
        img07 = findViewById(R.id.btn07)
        img08 = findViewById(R.id.btn08)
        img09 = findViewById(R.id.btn09)
        img10 = findViewById(R.id.btn10)
        img11 = findViewById(R.id.btn11)
        img12 = findViewById(R.id.btn12)
        img13 = findViewById(R.id.btn13)
        img14 = findViewById(R.id.btn14)
        img15 = findViewById(R.id.btn15)
        img16 = findViewById(R.id.btn16)
        img17 = findViewById(R.id.btn17)
        img18 = findViewById(R.id.btn18)
        img19 = findViewById(R.id.btn19)
        img20 = findViewById(R.id.btn20)
        img21 = findViewById(R.id.btn21)
        img22 = findViewById(R.id.btn22)
        img23 = findViewById(R.id.btn23)
        img24 = findViewById(R.id.btn24)

        imgPersonaje = findViewById(R.id.btnPersonaje)

        tablero.addAll(listOf(
            img01,img02,img03,img04,img05,img06,img07,img08,
            img09,img10,img11,img12,img13,img14,img15,img16,
            img17,img18,img19,img20,img21,img22,img23,img24)
        )
    }
    fun cargarBotones(){
        btnConectar = findViewById(R.id.btnConectar)
        btnChat = findViewById(R.id.btnChat)
    }
    fun cargarImagenes(){
        imagenes.add(R.drawable.per01)
        imagenes.add(R.drawable.per02)
        imagenes.add(R.drawable.per03)
        imagenes.add(R.drawable.per04)
        imagenes.add(R.drawable.per05)
        imagenes.add(R.drawable.per06)
        imagenes.add(R.drawable.per07)
        imagenes.add(R.drawable.per08)
        imagenes.add(R.drawable.per09)
        imagenes.add(R.drawable.per10)
        imagenes.add(R.drawable.per11)
        imagenes.add(R.drawable.per12)
        imagenes.add(R.drawable.per13)
        imagenes.add(R.drawable.per14)
        imagenes.add(R.drawable.per15)
        imagenes.add(R.drawable.per16)
        imagenes.add(R.drawable.per17)
        imagenes.add(R.drawable.per18)
        imagenes.add(R.drawable.per19)
        imagenes.add(R.drawable.per20)
        imagenes.add(R.drawable.per21)
        imagenes.add(R.drawable.per22)
        imagenes.add(R.drawable.per23)
        imagenes.add(R.drawable.per24)

        fondo = R.drawable.fondo
    }
    fun barajar(longitud : Int) : ArrayList<Int> {
        var result = arrayListOf<Int>()
        for (i in 0..longitud-1){
            //result.add(i%longitud)
            result.add(i)
        }
        result.shuffle()
        println(Arrays.toString(result.toArray()))
        println("tablero: " +tablero.size)
        println("longitud: " +longitud)
        return result
    }

    fun init() {
        cargarTablero()
        cargarBotones()
        cargarImagenes()
        arrayDesordenado = barajar(imagenes.size)
        println("Array Desordenado: " +arrayDesordenado.size)

        //cargamos personajes aleatoriamente en el tablero
        for (i in 0..tablero.size - 1){
            tablero[i].scaleType = ImageView.ScaleType.CENTER_CROP
            tablero[i].setImageResource(imagenes[arrayDesordenado[i]])
            //tablero[i].setImageResource(fondo)
        }

        //cargamos personaje aleatorio de jugador, el de arrayDesordenado pos 0
        imgPersonaje.setImageResource(imagenes[arrayDesordenado[0]])

        //Comenzamos a jugar, bajar personajes

    }
}