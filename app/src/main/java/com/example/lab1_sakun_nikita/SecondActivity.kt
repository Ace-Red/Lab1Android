package com.example.lab1_sakun_nikita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


import android.widget.TextView
import java.io.FileInputStream
import java.io.IOException


class SecondActivity : AppCompatActivity() {
    private val FILE_NAME = "content.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        openText()
    }

    fun openText() {
        var fin: FileInputStream? = null
        val textView = findViewById<TextView>(R.id.textView4)
        try {
            fin = openFileInput(FILE_NAME)
            val bytes = ByteArray(fin.available())
            fin.read(bytes)
            val text = String(bytes)
            textView.text = text
        } catch (ex: IOException) {
            textView.text = "Файл пустой"
            Toast.makeText(this, "Файл пустой", Toast.LENGTH_SHORT).show();
        } finally {
            try {
                fin?.close()
            } catch (ex: IOException) {
                Toast.makeText(this, "Ошибка закрытия потока", Toast.LENGTH_SHORT).show()
            }
        }
    }
}