package com.example.adivinaquien

import android.content.pm.ActivityInfo
import android.graphics.Color
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
import android.widget.Toast

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
    //var preguntasList:ListView = findViewById(R.id.preguntas_list)
    var arr = arrayListOf<String>()

    var personajeSelec: Personaje? = null
    var preguntaSelec: Pregunta? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Pantalla completa
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //quitamos title Bar
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) //forzamos orientacion horizontal
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        setContentView(R.layout.activity_entreuno)

        init()
    }

    fun asignarPersonaje(){
        var idPersonaje = 0
        var jsonPersonajes: String? = null

        val random = Random()
        idPersonaje = random.nextInt(1..24)
        println("ID: " + idPersonaje)

        val inputStreamPersonajes: InputStream = assets.open("Personajes.json")
        jsonPersonajes = inputStreamPersonajes.bufferedReader().use { it.readText() }

        var jsonArrPersonajes = JSONArray(jsonPersonajes)

        for(i in 0..jsonArrPersonajes.length()-1){
            var jsonObjPersonaje = jsonArrPersonajes.getJSONObject(i)
            if(jsonObjPersonaje.getString("id").toInt() == idPersonaje){
                personajeSelec = Personaje(
                    jsonObjPersonaje.getString("id").toInt(),
                    jsonObjPersonaje.getString("nombre"),
                    jsonObjPersonaje.getString("genero"),
                    jsonObjPersonaje.getString("piel"),
                    jsonObjPersonaje.getString("cabello"),
                    jsonObjPersonaje.getString("lentes"),
                    jsonObjPersonaje.getString("bigote"),
                    jsonObjPersonaje.getString("barba"),
                    jsonObjPersonaje.getString("corbata"),
                    jsonObjPersonaje.getString("playera")
                )
            }
        }

        println("Personaje asignado: " + personajeSelec?.nombre)
    }

    fun leerJSON(){
        var jsonPreguntas: String? = null
        var jsonPersonajes: String? = null

        //println("Personaje asignado 3: " + personajeSelec?.nombre)

        try{
            val inputStream: InputStream = assets.open("Preguntas.json")
            jsonPreguntas = inputStream.bufferedReader().use{it.readText()}
            val inputStreamPersonajes: InputStream = assets.open("Personajes.json")
            jsonPersonajes = inputStreamPersonajes.bufferedReader().use { it.readText() }

            var jsonArrPreguntas = JSONArray(jsonPreguntas)
            var jsonArrPersonajes = JSONArray(jsonPersonajes)

            for(i in 0..jsonArrPreguntas.length()-1){
                var jsonObjPregunta = jsonArrPreguntas.getJSONObject(i)
                arr.add(jsonObjPregunta.getString("pregunta"))
            }

            var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arr)

            val preguntasList:ListView = findViewById(R.id.preguntas_list)
            preguntasList.adapter = adapter

            preguntasList.setOnItemClickListener { parent, view, position, id ->

                for(i in 0..jsonArrPreguntas.length()-1){
                    var jsonObjPregunta = jsonArrPreguntas.getJSONObject(i)

                    if(jsonObjPregunta.getString("id").toInt() == id.toInt()){
                        preguntaSelec = Pregunta(
                            jsonObjPregunta.getString("id").toInt(),
                            jsonObjPregunta.getString("pregunta"),
                            jsonObjPregunta.getString("respuesta")
                        )
                    }
                }

                val toast = Toast.makeText(this, "${preguntaSelec?.respuesta}", Toast.LENGTH_SHORT)
                toast.show()
                val toast2 = Toast.makeText(this, "${personajeSelec?.genero}", Toast.LENGTH_SHORT)
                toast2.show()

                if(preguntaSelec?.respuesta == personajeSelec?.genero){
                    view.setBackgroundColor(Color.GREEN)
                }
                else{
                    view.setBackgroundColor(Color.RED)
                }
                
                /*for(i in 0..jsonArrPreguntas.length()-1){
                    var jsonObjPregunta = jsonArrPreguntas.getJSONObject(i)

                    val toast = Toast.makeText(this, "${jsonObjPregunta.getString("respuesta")}", Toast.LENGTH_SHORT)
                    toast.show()
                }

            var jsonObj = jsonArrPreguntas.getJSONObject(id.toInt())
                for(j in 0..jsonArrPersonajes.length()-1){
                    var jsonObjPersonajes = jsonArrPersonajes.getJSONObject(j)


                    if(jsonObjPreguntas.getString("genero") == personajeSelec?.genero){
                            val toast = Toast.makeText(this, "Es correcto", Toast.LENGTH_SHORT)
                            toast.show()

                    }
                    if(jsonObj.getString("respuesta") == jsonObjPersonajes.getString("genero")){
                        val toast = Toast.makeText(this, "Es correcto", Toast.LENGTH_SHORT)
                        toast.show()

                    }
                }*/
            }
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
        asignarPersonaje()

        leerJSON()

        cronometro()
        cargarTablero()
        cargarImagenes()
        arrayDesordenado = barajar(imagenes.size)
        println("Array Desordenado: " + arrayDesordenado.size)

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