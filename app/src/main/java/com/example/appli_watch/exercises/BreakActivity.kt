package com.example.appli_watch.exercises

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import android.widget.TextView
import com.example.appli_watch.R

class BreakActivity : AppCompatActivity() {
    private lateinit var rest: TextView
    private lateinit var countdown: CountDownTimer
    private var time: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_break)

        val intent = intent
        time = intent.getIntExtra("maxRepetitions", 0).toLong()
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        rest = findViewById(R.id.timeLeft)
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