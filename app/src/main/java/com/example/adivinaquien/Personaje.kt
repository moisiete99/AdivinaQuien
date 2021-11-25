package com.example.adivinaquien

class Personaje {
    private lateinit var nombre:String
    private lateinit var genero:String
    private lateinit var piel:String
    private lateinit var cabello:String
    private lateinit var lentes:String
    private lateinit var bigote:String
    private lateinit var barba:String
    private lateinit var corbata:String
    private lateinit var playera:String
    private var num:Int = 0

    constructor(nombre:String,genero:String,piel:String,cabello:String,lentes:String,
                bigote:String,barba:String,corbata:String,playera:String,num:Int){
        this.nombre = nombre
        this.genero = genero
        this.piel = piel
        this.cabello = cabello
        this.lentes = lentes
        this.bigote = bigote
        this.barba = barba
        this.corbata = corbata
        this.playera = playera
        this.num = num
    }
    public fun getNombre(): String {
        return nombre
    }

}
