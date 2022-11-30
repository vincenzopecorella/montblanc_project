package com.example.appli_watch.exercises

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.MainActivity
import com.example.appli_watch.Menu.End
import com.example.appli_watch.R
import com.example.appli_watch.utils.Next
import java.text.SimpleDateFormat
import java.util.*

class BreakActivity : AppCompatActivity() {
    private lateinit var button_pause: Button
    private lateinit var button_play: Button
    private lateinit var button_cancel: Button
    private lateinit var button_past: Button
    private lateinit var rest: TextView
    private lateinit var countdown: CountDownTimer
    private var timerest: Int = 0
    private var timerest_ini: Long = 0
    private lateinit var time : TextView
    private var exo = arrayListOf<String>()
    private var time_ini: Int = 0
    private lateinit var intent_next: Intent
    private lateinit var Nextexercise: String
    private var NextRep: Int = 0
    private var Next_exercise: Next = Next()
    private lateinit var Next_exo : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_break)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val intent = intent
        timerest_ini = intent.getIntExtra("Timeselection", 0).toLong()
        time_ini = intent.getIntExtra("Time_ini",0)
        exo = intent.getStringArrayListExtra("Exo") as ArrayList<String>

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        time = findViewById(R.id.HH)
        Next_exo = findViewById(R.id.next_exercise)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        time.text = currentTime

        rest = findViewById(R.id.timeLeft)
        button_cancel= findViewById(R.id.cancel)
        button_past= findViewById(R.id.past)
        button_pause = findViewById(R.id.stop)
        button_play = findViewById(R.id.play)

        NextRep = exo.get(2).toInt()
        Nextexercise = exo.get(1)
        exo.removeAt(1)
        exo.removeAt(1)
        val n = exo.get(0).toInt()-2
        exo.set(0,"${n}")

        intent_next= Next_exercise.getNextExercise(this,Nextexercise,NextRep,time_ini)
        intent_next.putExtra("Exo",exo)

        countdown = object: CountDownTimer(timerest_ini*1000,3){
            override fun onTick(p0: Long) {
                rest.text = "${(p0/1000).toInt()+1}"
                timerest = (p0/1000 + 1).toInt()
            }

            override fun onFinish() {
                rest.text = "Go"
                startActivity(intent_next)
                finish()
            }
        }
        countdown.start()

        if(Nextexercise=="Push Ups"||Nextexercise=="Board"||Nextexercise=="High Knees"||Nextexercise=="Butt Kicks"||Nextexercise=="Dips"||Nextexercise=="Climbers"||Nextexercise=="Arm Circles"){
            Next_exo.text="${NextRep}"+"s "+Nextexercise
        }
        else{
            Next_exo.text="${NextRep}"+" "+Nextexercise
        }

        button_play.setOnClickListener {
            button_pause.visibility=android.view.View.VISIBLE
            button_pause.isClickable=true
            button_play.visibility=android.view.View.INVISIBLE
            button_play.isClickable=false
            countdown.start()
        }

        button_pause.setOnClickListener {
            button_pause.visibility=android.view.View.INVISIBLE
            button_pause.isClickable=false
            button_play.visibility=android.view.View.VISIBLE
            button_play.isClickable=true
            countdown.cancel()
            rest.text = timerest.toString()
            countdown = object: CountDownTimer((timerest*1000).toLong(),3) {
                override fun onTick(p0: Long) {
                    rest.text = "${(p0 / 1000).toInt() + 1}"
                    timerest = (p0 / 1000 + 1).toInt()
                }

                override fun onFinish() {
                    startActivity(intent_next)
                    finish()
                }
            }
        }
        button_past.setOnClickListener {
            startActivity(intent_next)
            countdown.cancel()
            finish()
        }
        button_cancel.setOnClickListener {
            val intent_cancel = Intent(/* packageContext = */ this,/* cls = */
                MainActivity::class.java)
            startActivity(intent_cancel)
            countdown.cancel()
            finish()
        }
    }
}