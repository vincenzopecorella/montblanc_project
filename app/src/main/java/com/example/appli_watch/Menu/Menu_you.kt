package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.R
import java.text.SimpleDateFormat
import java.util.*

class Menu_you : AppCompatActivity() {
    private lateinit var button_reco: Button
    private lateinit var button_historic: Button
    private lateinit var button_analyses: Button
    private lateinit var button_data: Button
    private lateinit var time : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_you)

        button_reco = findViewById(R.id.reco)
        button_historic = findViewById(R.id.historic)
        button_analyses = findViewById(R.id.analyses)
        button_data = findViewById(R.id.data)

        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    while (true) {
                        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
                        val currentTime = sdf.format(Date())
                        time.text = currentTime
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }

        thread.start();

        val Intent_reco : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Menu_training::class.java)
        button_reco.setOnClickListener {
            startActivity(Intent_reco)
        }
        val Intent_historic : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Main_menu_old::class.java)
        button_historic.setOnClickListener {
            startActivity(Intent_historic)
        }
        val Intent_analyses : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Main_menu_old::class.java)
        button_analyses.setOnClickListener {
            startActivity(Intent_analyses)
        }
        val Intent_data : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Menu_training::class.java)
        button_data.setOnClickListener {
            startActivity(Intent_data)
        }



    }
}