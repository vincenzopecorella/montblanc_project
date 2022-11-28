package com.example.appli_watch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.Menu.Start
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*

class Overview : AppCompatActivity() {
    private lateinit var workout_name: String
    private lateinit var workout: TextView
    private lateinit var exercises: TextView
    private lateinit var start: Button
    private lateinit var time : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        val intent = intent
        workout_name = intent.getStringExtra("WorkoutName").toString()
        exercises = findViewById(R.id.exercises)
        workout = findViewById(R.id.workout)
        start = findViewById(R.id.start)

        workout.text = workout_name

        time = findViewById(R.id.HH)

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

        start.setOnClickListener {
            val Intent_start : Intent =  Intent(/* packageContext = */ this,/* cls = */
                Start::class.java)
//            Intent_start.putExtra("maxRepetitions", maxRepetitions)
//            Intent_start.putExtra("ExercisesName", exercise_name)
            startActivity(Intent_start)
        }

    }
}