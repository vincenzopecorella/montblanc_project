package com.example.appli_watch.trainings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.Menu.Menu_training
import com.example.appli_watch.Menu.Start
import com.example.appli_watch.R
import com.example.appli_watch.exercises.JumpingJacks
import java.text.SimpleDateFormat
import java.util.*

class Golf : AppCompatActivity() {
    private var exo = arrayListOf<String>("6","Jumping Jacks","10","Rest","10","Squats","20","End","0")
    private lateinit var workout: TextView
    private lateinit var exercises: TextView
    private lateinit var start: Button
    private lateinit var time : TextView
    private var maxRepetitions: Int = 0
    private lateinit var exercise_name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        exercises = findViewById(R.id.exercises)
        workout = findViewById(R.id.workout)
        start = findViewById(R.id.start)

        exercises.text = "Jumping Jacks   10\nSquats        20"
        workout.text = "Golf"

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

        if(exo.get(0).toInt()>=2){
            maxRepetitions = exo.get(2).toInt()
            exercise_name = exo.get(1)
            exo.removeAt(1)
            exo.removeAt(1)
            val n = exo.get(0).toInt()-2
            exo.set(0,"${n}")
        }
        else{
            val Intent_menu : Intent =  Intent(/* packageContext = */ this,/* cls = */
                Menu_training::class.java)
            startActivity(Intent_menu)
        }

        start.setOnClickListener {
            val Intent_start : Intent =  Intent(/* packageContext = */ this,/* cls = */
                Start::class.java)
            Intent_start.putExtra("maxRepetitions", maxRepetitions)
            Intent_start.putExtra("ExercisesName", exercise_name)
            Intent_start.putExtra("Exo",exo)
            startActivity(Intent_start)
        }

    }
}