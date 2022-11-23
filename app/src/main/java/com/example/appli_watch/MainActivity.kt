package com.example.appli_watch

import android.app.Activity
import android.os.Bundle
import com.example.appli_watch.databinding.ActivityMainBinding
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.Menu.Main_menu_old
import com.example.appli_watch.Menu.Menu_concierge
import com.example.appli_watch.Menu.Menu_training
import com.example.appli_watch.Menu.Menu_you
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var button_trainings: Button
    private lateinit var button_concierge: Button
    private lateinit var button_profile: Button
    private lateinit var time : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button_trainings = findViewById(R.id.training)
        button_concierge = findViewById(R.id.concierge)
        button_profile = findViewById(R.id.profile)

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())

        time.text = currentTime


        val Intent_Training : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Menu_training::class.java)
        button_trainings.setOnClickListener {
            startActivity(Intent_Training)
        }
        val Intent_concierge : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Menu_concierge::class.java)
        button_concierge.setOnClickListener {
            startActivity(Intent_concierge)
        }
        val Intent_profile : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Menu_you::class.java)
        button_profile.setOnClickListener {
            startActivity(Intent_profile)
        }
    }
}