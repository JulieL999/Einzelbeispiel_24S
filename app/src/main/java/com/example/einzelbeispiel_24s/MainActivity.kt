package com.example.einzelbeispiel_24s

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val matrNumber = findViewById<EditText>(R.id.matrNum)
        val sendButton = findViewById<Button>(R.id.button)
        sendButton.setOnClickListener {

        }
    }
}