package com.example.adivinaquien

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.util.*
import kotlin.collections.ArrayList

class EntreUno : AppCompatActivity() {

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

    //variables del juego
    var tablero = arrayListOf<ImageButton>()
    var arrayDesordenado = arrayListOf<Int>()
    var bloqueo : Boolean = false

    //imagenes
    var imagenes = arrayListOf<Int>()
    var fondo : Int = 0

    //Cronometro
    private lateinit var btnIniciar: Button
    private lateinit var cronometro: Chronometer

    //Preguntas
    //val preguntasList:ListView = findViewById(R.id.preguntas_list)
    var arr = arrayListOf<String>()

    var idPersonaje = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Pantalla completa
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //quitamos title Bar
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) //forzamos orientacion horizontal

        setContentView(R.layout.activity_entreuno)

        init()
    }

    fun leerJSON(){
        var json:String? = null

        try{
            val inputStream: InputStream = assets.open("Preguntas.json")
            json = inputStream.bufferedReader().use{it.readText()}

            var jsonarr = JSONArray(json)

            for(i in 0..jsonarr.length()-1){
                var jsonobj = jsonarr.getJSONObject(i)
                arr.add(jsonobj.getString("pregunta"))
            }

            var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arr)

            val preguntasList:ListView = findViewById(R.id.preguntas_list)
            preguntasList.adapter = adapter
        }
        catch (e:IOException){
            e.message?.let { Log.d("Error -> ", it) }
        }
    }

    fun cronometro() {
        //Cronometro
        btnIniciar = findViewById(R.id.btnIniciar)
        cronometro = findViewById(R.id.cronometro)
        btnIniciar.setOnClickListener {
            cronometro.base = SystemClock.elapsedRealtime()
            cronometro.start()
            btnIniciar.setVisibility(View.GONE)
        }
    }

    fun Random.nextInt(range: IntRange): Int{
        return range.start + nextInt(range.last - range.start)
    }

    fun cargarTablero() {
        img01 = findViewById(R.id.btnP1)
        img02 = findViewById(R.id.btnP2)
        img03 = findViewById(R.id.btnP3)
        img04 = findViewById(R.id.btnP4)
        img05 = findViewById(R.id.btnP5)
        img06 = findViewById(R.id.btnP6)
        img07 = findViewById(R.id.btnP7)
        img08 = findViewById(R.id.btnP8)
        img09 = findViewById(R.id.btnP9)
        img10 = findViewById(R.id.btnP10)
        img11 = findViewById(R.id.btnP11)
        img12 = findViewById(R.id.btnP12)
        img13 = findViewById(R.id.btnP13)
        img14 = findViewById(R.id.btnP14)
        img15 = findViewById(R.id.btnP15)
        img16 = findViewById(R.id.btnP16)
        img17 = findViewById(R.id.btnP17)
        img18 = findViewById(R.id.btnP18)
        img19 = findViewById(R.id.btnP19)
        img20 = findViewById(R.id.btnP20)
        img21 = findViewById(R.id.btnP21)
        img22 = findViewById(R.id.btnP22)
        img23 = findViewById(R.id.btnP23)
        img24 = findViewById(R.id.btnP24)

        //imgPersonaje = findViewById(R.id.btnPersonaje)

        tablero.addAll(listOf(
            img01,img02,img03,img04,img05,img06,img07,img08,
            img09,img10,img11,img12,img13,img14,img15,img16,
            img17,img18,img19,img20,img21,img22,img23,img24)
        )
    }

    fun cargarImagenes(){
        imagenes.add(R.drawable.esther01)
        imagenes.add(R.drawable.roger02)
        imagenes.add(R.drawable.sarai03)
        imagenes.add(R.drawable.tino04)
        imagenes.add(R.drawable.otto05)
        imagenes.add(R.drawable.lola06)
        imagenes.add(R.drawable.marcos07)
        imagenes.add(R.drawable.africa08)
        imagenes.add(R.drawable.thania09)
        imagenes.add(R.drawable.beth10)
        imagenes.add(R.drawable.orion11)
        imagenes.add(R.drawable.mika12)
        imagenes.add(R.drawable.nuth13)
        imagenes.add(R.drawable.ra14)
        imagenes.add(R.drawable.isaac15)
        imagenes.add(R.drawable.carmen16)
        imagenes.add(R.drawable.ramses17)
        imagenes.add(R.drawable.puca18)
        imagenes.add(R.drawable.goku19)
        imagenes.add(R.drawable.bielsa20)
        imagenes.add(R.drawable.gea21)
        imagenes.add(R.drawable.chica22)
        imagenes.add(R.drawable.xina23)
        imagenes.add(R.drawable.tot24)

        fondo = R.drawable.fondo
    }

    fun barajar(longitud:Int): ArrayList<Int>{
        var result = arrayListOf<Int>()
        for(i in 0..longitud-1){
            result.add(i)
        }
        result.shuffle()
        println(Arrays.toString(result.toArray()))
        println("tablero: " +tablero.size)
        println("longitud: " +longitud)
        return result
    }

    fun init(){
        //Asignamos el id del personaje
        val random = Random()
        idPersonaje = random.nextInt(1..24)

        leerJSON()

        cronometro()
        cargarTablero()
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
        //imgPersonaje.setImageResource(imagenes[arrayDesordenado[0]])

        //Comenzamos a jugar, bajar personajes
        for (i in 0..tablero.size - 1){
            //habilitamos tablero, botones
            tablero[i].isEnabled = true
            //Al seleccionar, tocar
            tablero[i].setOnClickListener{
                if(!bloqueo){
                    tablero[i].setImageResource(fondo)
                    tablero[i].isEnabled = false
                }
            }
        }
    }
}