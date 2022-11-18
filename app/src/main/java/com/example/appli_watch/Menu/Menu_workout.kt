package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.MainActivity
import com.example.appli_watch.R
import java.text.SimpleDateFormat
import java.util.*

class Menu_workout : AppCompatActivity() {

    private lateinit var button_advanced: Button
    private lateinit var button_intermediary: Button
    private lateinit var button_beginner: Button
    private lateinit var time : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_workout)

        button_advanced = findViewById(R.id.button_advanced)
        button_intermediary = findViewById(R.id.button_intermediary)
        button_beginner = findViewById(R.id.button_beginner)

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())

        time.text = currentTime

        val Intent_advanced : Intent =  Intent(/* packageContext = */ this,/* cls = */
            MainActivity::class.java)
        button_advanced.setOnClickListener {
            startActivity(Intent_advanced)
        }
        val Intent_intermediary : Intent =  Intent(/* packageContext = */ this,/* cls = */
            MainActivity::class.java)
        button_intermediary.setOnClickListener {
            startActivity(Intent_intermediary)
        }
        val Intent_beginner : Intent =  Intent(/* packageContext = */ this,/* cls = */
            MainActivity::class.java)
        button_beginner.setOnClickListener {
            startActivity(Intent_beginner)
        }

    }
}