package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.MainActivity
import com.example.appli_watch.R
import com.example.appli_watch.trainings.GolfBasicActivity
import java.text.SimpleDateFormat
import java.util.*

class Menu_warmup : AppCompatActivity() {

    private lateinit var button_golf: Button
    private lateinit var button_squash: Button
    private lateinit var button_horse: Button
    private lateinit var time : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_warmup)

        button_golf = findViewById(R.id.button_golf)
        button_squash = findViewById(R.id.button_squash)
        button_horse = findViewById(R.id.button_horse)

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())

        time.text = currentTime

        val Intent_squash : Intent =  Intent(/* packageContext = */ this,/* cls = */
            MainActivity::class.java)
        button_squash.setOnClickListener {
            startActivity(Intent_squash)
        }
        val Intent_golf : Intent =  Intent(/* packageContext = */ this,/* cls = */
            GolfBasicActivity::class.java)
        button_golf.setOnClickListener {
            startActivity(Intent_golf)
        }
        val Intent_horse : Intent =  Intent(/* packageContext = */ this,/* cls = */
            MainActivity::class.java)
        button_horse.setOnClickListener {
            startActivity(Intent_horse)
        }

    }
}