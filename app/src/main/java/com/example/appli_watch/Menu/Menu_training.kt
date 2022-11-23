package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.R
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

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())

        time.text = currentTime

        val Intent_golf : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Menu_training::class.java)
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

    }
}