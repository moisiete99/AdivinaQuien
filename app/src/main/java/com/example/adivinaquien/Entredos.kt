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
    var tablero : ArrayList<ImageButton> = ArrayList()
    var arrayDesordenado : ArrayList<Int> = ArrayList()

    //imagenes
    var imagenes : ArrayList<ImageButton> = ArrayList()
    var fondo : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //quitamos title Bar
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) //forzamos orientacion horizontal
        setContentView(R.layout.entredos)


        /*val tablero = arrayOf<ImageButton>(
            img01,img02,img03,img04,img05,img06,img07,img08,
            img09,img10,img11,img12,img13,img14,img15,img16,
            img17,img18,img19,img20,img21,img22,img23,img24)*/

        //init()
    }

    fun cargarTablero() {
        img01= findViewById(R.id.btn01)
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

        tablero[0] = img01
        tablero[1] = img02
        tablero[2] = img03
        tablero[3] = img04
        tablero[4] = img05
        tablero[5] = img06
        tablero[6] = img07
        tablero[7] = img08
        tablero[8] = img09
        tablero[9] = img10
        tablero[10] = img11
        tablero[11] = img12
        tablero[12] = img13
        tablero[13] = img14
        tablero[14] = img15
        tablero[15] = img16
        tablero[16] = img17
        tablero[17] = img18
        tablero[18] = img19
        tablero[19] = img20
        tablero[20] = img21
        tablero[21] = img22
        tablero[22] = img23
        tablero[23] = img24

    }
    fun cargarBotones(){
        btnConectar = findViewById(R.id.btnConectar)
        btnChat = findViewById(R.id.btnChat)
    }
    fun cargarImagenes(){
        imagenes[0].setImageResource(R.drawable.per01)
        imagenes[1].setImageResource(R.drawable.per02)
        imagenes[2].setImageResource(R.drawable.per03)
        imagenes[3].setImageResource(R.drawable.per04)
        imagenes[4].setImageResource(R.drawable.per05)
        imagenes[5].setImageResource(R.drawable.per06)
        imagenes[6].setImageResource(R.drawable.per07)
        imagenes[7].setImageResource(R.drawable.per08)
        imagenes[8].setImageResource(R.drawable.per09)
        imagenes[9].setImageResource(R.drawable.per10)
        imagenes[10].setImageResource(R.drawable.per11)
        imagenes[11].setImageResource(R.drawable.per12)
        imagenes[12].setImageResource(R.drawable.per13)
        imagenes[13].setImageResource(R.drawable.per14)
        imagenes[14].setImageResource(R.drawable.per15)
        imagenes[15].setImageResource(R.drawable.per16)
        imagenes[16].setImageResource(R.drawable.per17)
        imagenes[17].setImageResource(R.drawable.per18)
        imagenes[18].setImageResource(R.drawable.per19)
        imagenes[19].setImageResource(R.drawable.per20)
        imagenes[20].setImageResource(R.drawable.per21)
        imagenes[21].setImageResource(R.drawable.per22)
        imagenes[22].setImageResource(R.drawable.per23)
        imagenes[23].setImageResource(R.drawable.per24)
        /*imagenes = arrayOf(
            R.drawable.per01,
            R.drawable.per02,
            R.drawable.per03,
            R.drawable.per04,
            R.drawable.per05,
            R.drawable.per06,
            R.drawable.per07,
            R.drawable.per08,
            R.drawable.per09,
            R.drawable.per10,
            R.drawable.per11,
            R.drawable.per12,
            R.drawable.per13,
            R.drawable.per14,
            R.drawable.per15,
            R.drawable.per16,
            R.drawable.per17,
            R.drawable.per18,
            R.drawable.per19,
            R.drawable.per20,
            R.drawable.per21,
            R.drawable.per22,
            R.drawable.per23,
            R.drawable.per24,
        )*/

        fondo = R.drawable.fondo
    }
    fun barajar(longitud : Int) : ArrayList<Int> {
        var result : ArrayList<Int> = ArrayList()
        for (i in 1..longitud){
            result.add(i%longitud)
        }
        result.shuffle()
        println(Arrays.toString(result.toArray()))
        return result
    }

    fun init() {
        cargarTablero()
        cargarBotones()
        cargarImagenes()
        /*arrayDesordenado = barajar(imagenes.size)
        for (i in 0..tablero.size){
            //tablero[i]?.scaleType
            tablero[i].setImageResource(imagenes[i])
        }*/
    }

    /*fun asignarCarta(minimo : Int, maximo : Int): Int {
        return ThreadLocalRandom.current().nextInt(minimo, maximo)
    }*/
}