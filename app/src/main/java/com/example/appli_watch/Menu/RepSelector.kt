package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.R
import com.example.appli_watch.exercises.DeadBug
import com.example.appli_watch.exercises.JumpingJacks
import com.example.appli_watch.exercises.Squats
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RepSelector : AppCompatActivity() {
    private lateinit var exercise_name: String
    private var maxRepetitions: Int = 0
    private lateinit var exercise: TextView
    private lateinit var count: TextView
    private lateinit var add: FloatingActionButton
    private lateinit var remove: FloatingActionButton
    private lateinit var confirm: Button

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
            if(exercise_name == "Squats"){
                val Intent_squats : Intent =  Intent(/* packageContext = */ this,/* cls = */
                    Squats::class.java)
                Intent_squats.putExtra("maxRepetitions", 20)
                Intent_squats.putExtra("ExercisesName", exercise_name)
                startActivity(Intent_squats)
            }
            if(exercise_name == "Jumping Jacks"){
                val Intent_jumpingjacks : Intent =  Intent(/* packageContext = */ this,/* cls = */
                    JumpingJacks::class.java)
                Intent_jumpingjacks.putExtra("maxRepetitions", maxRepetitions)
                Intent_jumpingjacks.putExtra("ExercisesName", exercise_name)
                startActivity(Intent_jumpingjacks)
            }
            if(exercise_name == "Dead Bugs"){
                val Intent_deadbug : Intent =  Intent(/* packageContext = */ this,/* cls = */
                    DeadBug::class.java)
                Intent_deadbug.putExtra("maxRepetitions", 20)
                Intent_deadbug.putExtra("ExercisesName", exercise_name)
                startActivity(Intent_deadbug)
            }
        }
    }
}