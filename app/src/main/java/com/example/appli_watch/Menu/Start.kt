package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.R
import com.example.appli_watch.exercises.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*

class Start : AppCompatActivity() {
    private lateinit var exercise_name: String
    private var maxRepetitions: Int = 0
    private lateinit var exercise: TextView
    private lateinit var start: TextView
    private lateinit var time : TextView
    private lateinit var countdown: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val intent = intent
        maxRepetitions = intent.getIntExtra("maxRepetitions", 0)
        exercise_name = intent.getStringExtra("ExercisesName").toString()
        exercise = findViewById(R.id.trainingTitle)
        start = findViewById(R.id.start)
        exercise.text = maxRepetitions.toString().plus("  ").plus(exercise_name)

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())

        time.text = currentTime

        val Intent_jumpingjacks: Intent =  Intent(/* packageContext = */ this,/* cls = */
                JumpingJacks::class.java)
        Intent_jumpingjacks.putExtra("maxRepetitions", maxRepetitions)
        Intent_jumpingjacks.putExtra("ExercisesName", exercise_name)

        val Intent_deadbug : Intent =  Intent(/* packageContext = */ this,/* cls = */
            DeadBug::class.java)
        Intent_deadbug.putExtra("maxRepetitions", maxRepetitions)
        Intent_deadbug.putExtra("ExercisesName", exercise_name)

        val Intent_squats : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Squats::class.java)
        Intent_squats.putExtra("maxRepetitions", maxRepetitions)
        Intent_squats.putExtra("ExercisesName", exercise_name)

        val Intent_lunges : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Lunges::class.java)
        Intent_lunges.putExtra("maxRepetitions", maxRepetitions)
        Intent_lunges.putExtra("ExercisesName", exercise_name)

        val Intent_birddogs : Intent =  Intent(/* packageContext = */ this,/* cls = */
            BirdDogs::class.java)
        Intent_birddogs.putExtra("maxRepetitions", maxRepetitions)
        Intent_birddogs.putExtra("ExercisesName", exercise_name)

        countdown = object: CountDownTimer(3000,3){
            override fun onTick(p0: Long) {
                start.text = "${p0/1000.toInt()+1}"
            }

            override fun onFinish() {
                try{
                    if(exercise_name == "Squats"){
                        startActivity(Intent_squats)
                    }
                    if(exercise_name == "Jumping Jacks"){
                        startActivity(Intent_jumpingjacks)
                    }
                    if(exercise_name == "Dead Bugs"){
                        startActivity(Intent_deadbug)
                    }
                    if(exercise_name == "Lunges"){
                        startActivity(Intent_lunges)
                    }
                    if(exercise_name == "Bird Dogs"){
                        startActivity(Intent_birddogs)
                    }

                }catch (e: Exception){
                    print(e)
                }
            }
        }

        countdown.start()

    }
}