package com.example.appli_watch

import android.app.Activity
import android.os.Bundle
import com.example.appli_watch.databinding.ActivityMainBinding
import android.content.Intent
import android.widget.Button
import com.example.appli_watch.trainings.GolfBasicActivity

class MainActivity : Activity() {
    private lateinit var buttonS: Button
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonS = findViewById(R.id.button_squats)

        val monIntent : Intent =  Intent( this, Main_Menu::class.java)
        buttonS.setOnClickListener {
            try{
                startActivity(monIntent)
            }catch (e:Exception){
                print("ciao")
            }
        }
    }
}