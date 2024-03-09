package com.example.einzelbeispiel_24s

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private val matrNum = 11827816
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // -------------------- first task --------------------------

        val answerTextView = findViewById<TextView>(R.id.answer)
        val matrNumber = findViewById<EditText>(R.id.matrNum)
        val sendButton = findViewById<Button>(R.id.button)
        var answerFromServer: String
        val client = ConnectionToServer()

        sendButton.setOnClickListener {
            val scope = CoroutineScope(Dispatchers.Default)
            scope.launch {
                withContext(Dispatchers.IO) {
                    answerFromServer = client.connectToServer(matrNumber.text.toString())
                    Log.d("ANSWER_FROM_SERVER", answerFromServer)
                }
                withContext(Dispatchers.Main) {
                    answerTextView.text = answerFromServer
                }
            }
        }

        // -------------------- second task ------------------------
        val exerciseNum = matrNum % 7
        Log.i("EXERCISE_NUMBER", exerciseNum.toString())

        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        val math = Mathematic()
        calculateBtn.setOnClickListener {
            val matr = matrNumber.text.toString()
            if (matr.length != 8) {
                answerTextView.text = getString(R.string.invalid_number)
            }
            else {
                val calculated = math.modifyMatrNumber(matr)
                answerTextView.text = calculated
            }

        }
    }

}