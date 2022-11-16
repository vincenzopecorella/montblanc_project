package com.example.appli_watch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import com.example.appli_watch.exercises.Squats

class start_squats : Activity() {

    private lateinit var button_start: Button
    private lateinit var countdown: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_squats)

        button_start = findViewById(R.id.button_start)
        val monIntent : Intent =  Intent(this, Squats::class.java)
        countdown = object: CountDownTimer(3000,3){
            override fun onTick(p0: Long) {
                button_start.text = "${p0/1000.toInt()+1}"
            }

            override fun onFinish() {
                try{
                    startActivity(monIntent)
                }catch (e: Exception){
                    print(e)
                }
            }
        }

        button_start.setOnClickListener {
            countdown.start()
        }
    }
}