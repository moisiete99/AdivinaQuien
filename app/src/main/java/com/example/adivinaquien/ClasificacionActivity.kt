package com.example.adivinaquien

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ClasificacionActivity : AppCompatActivity() {

    //lateinit var lvDatos: ListView
    lateinit var txtc0: TextView
    lateinit var txtc1: TextView
    lateinit var txtc2: TextView
    lateinit var txtc3: TextView
    lateinit var txtc4: TextView
    lateinit var mDbRef: DatabaseReference
    lateinit var mAuth: FirebaseAuth
    var datosList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //quitamos title Bar
        setContentView(R.layout.activity_clasificacion)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance() //intancia para autentificacion
        mDbRef = FirebaseDatabase.getInstance().getReference() //instancia para BD

        txtc0 = findViewById(R.id.txt_c0)
        txtc1 = findViewById(R.id.txt_c1)
        txtc2 = findViewById(R.id.txt_c2)
        txtc3 = findViewById(R.id.txt_c3)
        txtc4 = findViewById(R.id.txt_c4)

        leerClasificacionBD()
    }

    fun leerClasificacionBD() {
        mDbRef.child("clasificacion").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val myuid: String = mAuth.currentUser?.uid!!
                println("MyUID: " + myuid)
                for (postSnapshot in snapshot.children) {
                    val fechaBD = postSnapshot.value.toString()

                    println(postSnapshot)
                    if (postSnapshot.key.toString() == myuid) { //mostramos de nuestro propio usuario
                        datosList.add(fechaBD)
                    }
                }

                println("datosList: " + datosList.size)//2
                if (datosList.size == 0)
                    println("No hay datos")
                if (datosList.size == 1) {
                    txtc0.text = datosList[0]
                }
                if (datosList.size == 2) {
                    txtc0.text = datosList[0]
                    txtc1.text = datosList[1]
                }
                if (datosList.size == 3) {
                    txtc0.text = datosList[0]
                    txtc1.text = datosList[1]
                    txtc2.text = datosList[2]
                }
                if (datosList.size == 4) {
                    txtc0.text = datosList[0]
                    txtc1.text = datosList[1]
                    txtc2.text = datosList[2]
                    txtc3.text = datosList[3]
                }
                if (datosList.size == 5) {
                    txtc0.text = datosList[0]
                    txtc1.text = datosList[1]
                    txtc2.text = datosList[2]
                    txtc3.text = datosList[3]
                    txtc4.text = datosList[4]
                }
                //println("Clasificaciones" + Arrays.toString(datosList.toArray()))
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}