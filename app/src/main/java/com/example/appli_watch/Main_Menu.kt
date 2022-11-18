package com.example.appli_watch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.Menu.Menu_warmup
import com.example.appli_watch.Menu.Menu_workout
import java.text.SimpleDateFormat
import java.util.*

class Main_Menu : AppCompatActivity() {
    private lateinit var button_exercise: Button
    private lateinit var button_workout: Button
    private lateinit var button_warmup: Button
    private lateinit var time : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training_menu)

        button_exercise = findViewById(R.id.button_exercise)
        button_workout = findViewById(R.id.button_workout)
        button_warmup = findViewById(R.id.button_warmup)

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())

        time.text = currentTime

        val Intent_exercise : Intent =  Intent(/* packageContext = */ this,/* cls = */
            start_squats::class.java)
        button_exercise.setOnClickListener {
            startActivity(Intent_exercise)
        }
        val Intent_workout : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Menu_workout::class.java)
        button_workout.setOnClickListener {
            startActivity(Intent_workout)
        }
        val Intent_warmup : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Menu_warmup::class.java)
        button_warmup.setOnClickListener {
            startActivity(Intent_warmup)
        }
    }
}