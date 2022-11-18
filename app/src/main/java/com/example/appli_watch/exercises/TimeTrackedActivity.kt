package com.example.appli_watch.exercises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.appli_watch.R

class TimeTrackedActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rest: TextView
    private lateinit var button_pause: Button
    private lateinit var exerciseString: TextView
    private lateinit var countdown: CountDownTimer
    private var initialTime: Long = 0
    private var leftTime: Int = 0
    private var pause: Boolean = false
    private lateinit var exerciseName: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_tracked)

        val intent = intent
        initialTime = intent.getIntExtra("time", 0).toLong()
        exerciseName = intent.getStringExtra("exerciseName").toString()
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)


        rest = findViewById(R.id.timeLeft)
        exerciseString = findViewById(R.id.exercisesName)
        button_pause = findViewById(R.id.button_pause)
        button_pause.setOnClickListener(this)

        exerciseString.text = exerciseName
        countdown = object: CountDownTimer(initialTime*1000,3){
            override fun onTick(p0: Long) {
                rest.text = "${(p0/1000).toInt()+1}"
                leftTime = (p0/1000 + 1).toInt()
            }

            override fun onFinish() {
                val intent = Intent()
                setResult(RESULT_OK, intent)
                finish()
            }
        }
        countdown.start()
    }

    override fun onClick(view: View?) {
        if(pause){
            button_pause.text = "Pause"
            pause = false
            countdown.start()
        } else {
            button_pause.text = "Play"
            pause = true
            countdown.cancel()
            rest.text = leftTime.toString()
            countdown = object: CountDownTimer((leftTime*1000).toLong(),3) {
                override fun onTick(p0: Long) {
                    rest.text = "${(p0 / 1000).toInt() + 1}"
                    leftTime = (p0 / 1000 + 1).toInt()
                }

                override fun onFinish() {
                    val intent = Intent()
                    setResult(RESULT_OK, intent)
                    finish()
                }
            }
        }
    }
}