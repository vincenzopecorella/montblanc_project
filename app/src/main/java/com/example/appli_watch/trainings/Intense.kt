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

class Intense : AppCompatActivity() {
    private var exo = arrayListOf<String>("110","Jumping Jacks","30","Rest","10","Jumping Jacks","30","Rest","15","Push Ups","45","Rest","20","Push Ups","45","Rest","20","Push Ups","30","Rest","20","Climbers","30","Rest","20","Squats","25","Rest","15","Climbers","45","Rest","20","Squats","25","Rest","15","Climbers","30","Rest","20","Squats","25","Rest","30","Sit Ups","15","Rest","25","Sit Ups","25","Rest","20","Sit Ups","25","Rest","20","Sit Ups","25","Rest","35","Lunges","20","Rest","15","Lunges","20","Rest","20","Bird Dogs","15","Rest","15","Bird Dogs","15","Rest","20","Dead Bugs","15","Rest","20","Dead Bugs","15","Rest","30","Dips","30","Rest","20","Dips","30","Rest","20","Board","60","Push Ups","30","Rest","20","Lunges","10","Rest","25","Squats","25","Rest","20","Board","45","End","0")
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

        exercises.text = "Jumping Jacks   60\nPush Ups        150s\nClimbers        105s\nSquats       100\nSit Ups           75\nLunges            50\nBird Dogs         30\nDead Bugs          30\nDips             60s\nBoard            90s"
        workout.text = "Advanced"

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