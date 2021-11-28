package com.example.adivinaquien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class Chat2 : AppCompatActivity() {

    lateinit var chatRecyclerView: RecyclerView
    lateinit var messageBox: EditText
    lateinit var sendButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat2)

        val name =intent.getStringExtra("name")
        val uid = intent.getStringExtra("uid")

        supportActionBar?.title=name

        chatRecyclerView=findViewById(R.id.chatRecyclerView)
        messageBox=findViewById(R.id.messageBox)
        sendButton=findViewById(R.id.sentButton)
    }
}