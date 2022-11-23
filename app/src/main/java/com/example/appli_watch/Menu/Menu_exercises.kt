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
import java.text.SimpleDateFormat
import java.util.*

class Menu_exercises : AppCompatActivity() {
    private lateinit var button_jumpingjacks: Button
    private lateinit var button_squats: Button
    private lateinit var button_deadbug: Button
    private lateinit var button_birddogs: Button
    private lateinit var button_lunges: Button
    private lateinit var time : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_exercises)

        button_jumpingjacks = findViewById(R.id.jumpingjacks)
        button_squats = findViewById(R.id.squats)
        button_deadbug = findViewById(R.id.deadbugs)
        button_birddogs = findViewById(R.id.birddogs)
        button_lunges = findViewById(R.id.lunges)

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())

        time.text = currentTime

        val Intent_jumpingjacks : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_jumpingjacks.putExtra("ExercisesName", "Jumping Jacks")
        button_jumpingjacks.setOnClickListener {
            startActivity(Intent_jumpingjacks)
        }
        val Intent_squats : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_squats.putExtra("ExercisesName", "Squats")
        button_squats.setOnClickListener {
            startActivity(Intent_squats)
        }
        val Intent_deadbug : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_deadbug.putExtra("ExercisesName", "Dead Bugs")
        button_deadbug.setOnClickListener {
            startActivity(Intent_deadbug)
        }
        val Intent_birddogs : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_birddogs.putExtra("ExercisesName", "Bird Dogs")
        button_birddogs.setOnClickListener {
            startActivity(Intent_birddogs)
        }
        val Intent_lunges : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_lunges.putExtra("ExercisesName", "Lunges")
        button_lunges.setOnClickListener {
            startActivity(Intent_lunges)
        }
    }
}