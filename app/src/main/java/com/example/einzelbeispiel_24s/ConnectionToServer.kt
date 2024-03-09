package com.example.einzelbeispiel_24s

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Exception
import java.net.Socket

class ConnectionToServer {
    private val url : String = "se2-submission.aau.at"
    private val port = 20080

    suspend fun connectToServer(msg: String) : String  {
        return withContext(Dispatchers.IO) {
            try {
                val socket = Socket(url, port)
                val writer = PrintWriter(socket.getOutputStream(), true)
                writer.println(msg)
                val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
                val response = reader.readLine()
                socket.close()
                response
            }
            catch (e: Exception) {
                Log.e("ERROR", "Unfortunately, an error has occur!")
                e.printStackTrace()
                "Unfortunately, an error has occur!"
            }
        }

    }
}