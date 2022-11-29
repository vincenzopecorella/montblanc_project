package com.example.appli_watch.Menu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appli_watch.R
import com.example.appli_watch.exercises.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class RepSelector : AppCompatActivity() {
    private var exo = arrayListOf<String>("2","End","0")
    private lateinit var exercise_name: String
    private var maxRepetitions: Int = 0
    private lateinit var exercise: TextView
    private lateinit var count: TextView
    private lateinit var add: FloatingActionButton
    private lateinit var remove: FloatingActionButton
    private lateinit var confirm: Button
    private lateinit var time : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rep_selector)

        val intent = intent
        exercise_name = intent.getStringExtra("ExercisesName").toString()
        exercise = findViewById(R.id.trainingTitle)
        add = findViewById(R.id.add)
        remove = findViewById(R.id.remove)
        count = findViewById(R.id.count)
        confirm = findViewById(R.id.confirmation)
        exercise.text = exercise_name

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



        add.setOnClickListener {
            maxRepetitions+=1
            count.text= maxRepetitions.toString()
        }

        remove.setOnClickListener {
            if(maxRepetitions>0){
                maxRepetitions-=1
            }
            count.text= maxRepetitions.toString()
        }

        confirm.setOnClickListener {
            if(maxRepetitions == 0){
                return@setOnClickListener
            }

            val Intent_start : Intent =  Intent(/* packageContext = */ this,/* cls = */
                    Start::class.java)
            Intent_start.putExtra("maxRepetitions", maxRepetitions)
            Intent_start.putExtra("ExercisesName", exercise_name)
            Intent_start.putExtra("Exo",exo)
            startActivity(Intent_start)

        }
    }
}