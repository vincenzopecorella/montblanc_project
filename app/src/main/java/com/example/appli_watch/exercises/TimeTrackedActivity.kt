package com.example.appli_watch.exercises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.example.appli_watch.R

class TimeTrackedActivity : AppCompatActivity() {
    private lateinit var rest: TextView
    private lateinit var exerciseString: TextView
    private lateinit var countdown: CountDownTimer
    private var time: Long = 0
    private lateinit var exerciseName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_tracked)

        val intent = intent
        time = intent.getIntExtra("time", 0).toLong()
        exerciseName = intent.getStringExtra("exerciseName").toString()


        rest = findViewById(R.id.timeLeft)
        exerciseString = findViewById(R.id.exercisesName)

        exerciseString.text = exerciseName
        countdown = object: CountDownTimer(time*1000,3){
            override fun onTick(p0: Long) {
                rest.text = "${p0/1000.toInt()+1}"
            }

            override fun onFinish() {
                val intent = Intent()
                setResult(RESULT_OK, intent)
                finish()
            }
        }
        countdown.start()
    }
}