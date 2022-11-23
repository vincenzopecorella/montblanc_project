package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.MainActivity
import com.example.appli_watch.R
import com.example.appli_watch.exercises.DeadBug
import java.text.SimpleDateFormat
import java.util.*

class End : AppCompatActivity() {
    private lateinit var duration: TextView
    private var duration2: Int = 0
    private lateinit var time : TextView
    private lateinit var menu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)


        val intent = intent
        duration2 = intent.getIntExtra("Duration", 0)
        menu = findViewById(R.id.menu)
        duration = findViewById(R.id.duration)
        duration.text = duration2.toString()

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())

        time.text = currentTime

        menu.setOnClickListener {
            val Intent_menu : Intent =  Intent(/* packageContext = */ this,/* cls = */
                MainActivity::class.java)
            startActivity(Intent_menu)
        }

    }
}