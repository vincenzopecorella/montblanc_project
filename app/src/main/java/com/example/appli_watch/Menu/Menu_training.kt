package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.R
import com.example.appli_watch.trainings.Golf
import com.example.appli_watch.trainings.GolfBasicActivity
import java.text.SimpleDateFormat
import java.util.*

class Menu_training : AppCompatActivity() {
    private lateinit var button_golf: Button
    private lateinit var button_horse: Button
    private lateinit var button_squash: Button
    private lateinit var button_beginner: Button
    private lateinit var button_intermediary: Button
    private lateinit var button_advanced: Button
    private lateinit var button_squats: Button
    private lateinit var button_jumping: Button
    private lateinit var button_dead: Button
    private lateinit var button_lunges: Button
    private lateinit var button_bird: Button
    private lateinit var button_push: Button
    private lateinit var button_sit: Button
    private lateinit var button_board: Button
    private lateinit var button_kicks: Button
    private lateinit var button_heel: Button
    private lateinit var button_dips: Button
    private lateinit var button_climb: Button
    private lateinit var time : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_training)

        button_golf = findViewById(R.id.golf)
        button_horse = findViewById(R.id.horse)
        button_squash = findViewById(R.id.squash)
        button_beginner = findViewById(R.id.beginner)
        button_intermediary = findViewById(R.id.intermediary)
        button_advanced = findViewById(R.id.advanced)
        button_squats = findViewById(R.id.squats)
        button_jumping = findViewById(R.id.jumpingjacks)
        button_dead = findViewById(R.id.deadbug)
        button_lunges = findViewById(R.id.lunges)
        button_bird = findViewById(R.id.bird)
        button_push = findViewById(R.id.push)
        button_sit = findViewById(R.id.sit)
        button_board = findViewById(R.id.board)
        button_kicks = findViewById(R.id.kicks)
        button_heel = findViewById(R.id.heel)
        button_dips = findViewById(R.id.dips)
        button_climb = findViewById(R.id.climb)

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

        val Intent_golf : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Golf::class.java)
        button_golf.setOnClickListener {
            startActivity(Intent_golf)
        }
        val Intent_horse : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Main_menu_old::class.java)
        button_horse.setOnClickListener {
            startActivity(Intent_horse)
        }
        val Intent_squash : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Main_menu_old::class.java)
        button_squash.setOnClickListener {
            startActivity(Intent_squash)
        }
        val Intent_beginner : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Menu_training::class.java)
        button_beginner.setOnClickListener {
            startActivity(Intent_beginner)
        }
        val Intent_intermediary : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Main_menu_old::class.java)
        button_intermediary.setOnClickListener {
            startActivity(Intent_intermediary)
        }
        val Intent_advanced : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Main_menu_old::class.java)
        button_advanced.setOnClickListener {
            startActivity(Intent_advanced)
        }
        val Intent_squats : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_squats.putExtra("ExercisesName", "Squats")
        button_squats.setOnClickListener {
            startActivity(Intent_squats)
        }
        val Intent_jumping : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_jumping.putExtra("ExercisesName", "Jumping Jacks")
        button_jumping.setOnClickListener {
            startActivity(Intent_jumping)
        }
        val Intent_dead : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_dead.putExtra("ExercisesName", "Dead Bugs")
        button_dead.setOnClickListener {
            startActivity(Intent_dead)
        }
        val Intent_lunges : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_lunges.putExtra("ExercisesName", "Lunges")
        button_lunges.setOnClickListener {
            startActivity(Intent_lunges)
        }
        val Intent_bird : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_bird.putExtra("ExercisesName", "Bird Dogs")
        button_bird.setOnClickListener {
            startActivity(Intent_bird)
        }
        val Intent_push : Intent =  Intent(/* packageContext = */ this,/* cls = */
            TimeSelector::class.java)
        Intent_push.putExtra("ExercisesName", "Push Ups")
        button_push.setOnClickListener {
            startActivity(Intent_push)
        }
        val Intent_sit : Intent =  Intent(/* packageContext = */ this,/* cls = */
            RepSelector::class.java)
        Intent_sit.putExtra("ExercisesName", "Sit Ups")
        button_sit.setOnClickListener {
            startActivity(Intent_sit)
        }
        val Intent_board : Intent =  Intent(/* packageContext = */ this,/* cls = */
            TimeSelector::class.java)
        Intent_board.putExtra("ExercisesName", "Board")
        button_board.setOnClickListener {
            startActivity(Intent_board)
        }
        val Intent_kicks : Intent =  Intent(/* packageContext = */ this,/* cls = */
            TimeSelector::class.java)
        Intent_kicks.putExtra("ExercisesName", "High Knees")
        button_kicks.setOnClickListener {
            startActivity(Intent_kicks)
        }
        val Intent_heel : Intent =  Intent(/* packageContext = */ this,/* cls = */
            TimeSelector::class.java)
        Intent_heel.putExtra("ExercisesName", "Butt Kicks")
        button_heel.setOnClickListener {
            startActivity(Intent_heel)
        }
        val Intent_dips : Intent =  Intent(/* packageContext = */ this,/* cls = */
            TimeSelector::class.java)
        Intent_dips.putExtra("ExercisesName", "Dips")
        button_dips.setOnClickListener {
            startActivity(Intent_dips)
        }
        val Intent_climb : Intent =  Intent(/* packageContext = */ this,/* cls = */
            TimeSelector::class.java)
        Intent_climb.putExtra("ExercisesName", "Climbers")
        button_climb.setOnClickListener {
            startActivity(Intent_climb)
        }

    }
}