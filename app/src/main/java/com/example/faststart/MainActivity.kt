package com.example.faststart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private var time:String = "00:00:00"
    private var isRunState = false
    private var referenceTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.et_timer_scoreboard)
        val receiveText = editText.text.toString()
    }
}