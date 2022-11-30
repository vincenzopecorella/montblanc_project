package com.example.appli_watch.trainings

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.appli_watch.R
import com.example.appli_watch.exercises.*
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

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

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


        resultLauncher.launch(nextIntent)
        startButton.setOnClickListener {
            resultLauncher.launch(nextIntent)
        }
    }

    private fun nextExercise(){
        when(exercisesCount){
            0 -> {
                nextExerciseName.text = "Jumping Jacks"
                nextExerciseMetric.text = "3 repetitions"
                nextIntent =  Intent(this,JumpingJacks::class.java)
                nextIntent.putExtra("maxRepetitions", 3)
                nextIntent.putExtra("ExercisesName", "Jumping Jacks")
            }
            1 -> {
                nextExerciseName.text = "Jumping Jacks"
                nextExerciseMetric.text = "4 repetitions"
                nextIntent =  Intent(this,JumpingJacks::class.java)
                nextIntent.putExtra("maxRepetitions", 4)
                nextIntent.putExtra("ExercisesName", "Jumping Jacks")
                startButton.performClick()
            }
            2 -> {
                nextExerciseName.text = "Jumping Jacks"
                nextExerciseMetric.text = "5 repetitions"
                nextIntent =  Intent(this,JumpingJacks::class.java)
                nextIntent.putExtra("maxRepetitions", 5)
                nextIntent.putExtra("ExercisesName", "Jumping Jacks")
                startButton.performClick()
            }
            3 -> {
                nextExerciseName.text = "Jumping Jacks"
                nextExerciseMetric.text = "6 repetitions"
                nextIntent =  Intent(this,JumpingJacks::class.java)
                nextIntent.putExtra("maxRepetitions", 6)
                nextIntent.putExtra("ExercisesName", "Jumping Jacks")
                startButton.performClick()
            }
            4 -> {
                //to something
            }
        }
    }
}