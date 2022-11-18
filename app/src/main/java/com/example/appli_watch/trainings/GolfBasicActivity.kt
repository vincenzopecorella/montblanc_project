package com.example.appli_watch.trainings

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.appli_watch.R
import com.example.appli_watch.exercises.BirdDog
import com.example.appli_watch.exercises.BreakActivity
import com.example.appli_watch.exercises.Squats
import com.example.appli_watch.exercises.TimeTrackedActivity
import com.example.appli_watch.start_squats

class GolfBasicActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    private var exercisesCount = 0
    private var nextIntent: Intent = Intent()
    private lateinit var nextExerciseName: TextView
    private lateinit var nextExerciseMetric: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_golf_basic)

        startButton = findViewById(R.id.startTraining)
        nextExerciseName = findViewById(R.id.nextExercise)
        nextExerciseMetric = findViewById(R.id.metric)
        nextExercise()



        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                exercisesCount +=1
                nextExercise()
            }
        }


        startButton.setOnClickListener {
            resultLauncher.launch(nextIntent)
        }
    }

    private fun nextExercise(){
        when(exercisesCount){
            0 -> {
                nextExerciseName.text = "Bird Dogs"
                nextExerciseMetric.text = "5 repetitions"
                nextIntent =  Intent(this,BirdDog::class.java)
                nextIntent.putExtra("maxRepetitions", 5)
            }
            1 -> {
                nextExerciseName.text = "Rest"
                nextExerciseMetric.text = "5 seconds"
                nextIntent = Intent(this,BreakActivity::class.java)
                nextIntent.putExtra("time", 5)
            }
            2 -> {
                nextExerciseName.text = "Squats"
                nextExerciseMetric.text = "10 repetitions"
                nextIntent =  Intent(this,Squats::class.java)
                nextIntent.putExtra("maxRepetitions", 2)
            }
            3 -> {
                nextExerciseName.text = "Rest"
                nextExerciseMetric.text = "10 seconds"
                nextIntent = Intent(this,BreakActivity::class.java)
                nextIntent.putExtra("time", 10)
            }
            4 -> {
                //to something
            }
        }
    }
}