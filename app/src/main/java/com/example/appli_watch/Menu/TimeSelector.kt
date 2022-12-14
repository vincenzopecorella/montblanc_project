package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*

class TimeSelector : AppCompatActivity() {
    private lateinit var exercise_name: String
    private var exo = arrayListOf<String>("2","End","0")
    private var maxRepetitions: Int = 0
    private lateinit var exercise: TextView
    private lateinit var count: TextView
    private lateinit var add: FloatingActionButton
    private lateinit var remove: FloatingActionButton
    private lateinit var confirm: Button
    private lateinit var time : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_selector)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val intent = intent
        exercise_name = intent.getStringExtra("ExercisesName").toString()
        exercise = findViewById(R.id.trainingTitle)
        add = findViewById(R.id.add)
        remove = findViewById(R.id.remove)
        count = findViewById(R.id.count)
        confirm = findViewById(R.id.confirmation)
        exercise.text = exercise_name

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        time.text = currentTime

        add.setOnClickListener {
            maxRepetitions+=5
            count.text= maxRepetitions.toString()
        }

        remove.setOnClickListener {
            if(maxRepetitions>0){
                maxRepetitions-=5
            }
            count.text= maxRepetitions.toString()
        }

        confirm.setOnClickListener {
            if(maxRepetitions == 0){
                return@setOnClickListener
            }

            val Intent_start : Intent =  Intent(/* packageContext = */ this,/* cls = */
                Start::class.java)
            Intent_start.putExtra("Timeselection", maxRepetitions)
            Intent_start.putExtra("ExercisesName", exercise_name)
            Intent_start.putExtra("Exo",exo)
            startActivity(Intent_start)
            finish()

        }
    }
}