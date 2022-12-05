package com.example.appli_watch.trainings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.Menu.Menu_training
import com.example.appli_watch.Menu.Start
import com.example.appli_watch.R
import java.text.SimpleDateFormat
import java.util.*

class Squash : AppCompatActivity() {
    private var exo = arrayListOf<String>("30","High Knees","30","Rest","10","Butt Kicks","30","Rest","10","Jumping Jacks","30","Rest","15","Arm Circles","30","Rest","10","Arm Circles","30","Rest","10","Squats","20","Rest","15","Bird Dogs","10","Lunges","10","End","0")
    private lateinit var workout: TextView
    private lateinit var exercises: TextView
    private lateinit var start: Button
    private lateinit var time : TextView
    private var maxRepetitions: Int = 0
    private lateinit var exercise_name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        exercises = findViewById(R.id.exercises)
        workout = findViewById(R.id.workout)
        start = findViewById(R.id.start)

        exercises.text = "High Knees       30s\nButt Kicks       30s\nJumping Jacks     30\nArm Circles       60s\nSquats            20\nBird Dogs           10\nLunges            10"
        workout.text = "Squash"

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        time.text = currentTime

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
            finish()
        }

        start.setOnClickListener {
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