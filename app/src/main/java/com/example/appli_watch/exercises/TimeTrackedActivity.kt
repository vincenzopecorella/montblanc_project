package com.example.appli_watch.exercises

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.appli_watch.MainActivity
import com.example.appli_watch.Menu.End
import com.example.appli_watch.Menu.Menu_training
import com.example.appli_watch.R
import com.example.appli_watch.utils.Next
import java.text.SimpleDateFormat
import java.util.*


class TimeTrackedActivity : AppCompatActivity() {
    private lateinit var rest: TextView
    private lateinit var button_pause: Button
    private lateinit var button_play: Button
    private lateinit var button_cancel: Button
    private lateinit var button_past: Button
    private lateinit var exerciseString: TextView
    private lateinit var countdown: CountDownTimer
    private var initialTime: Long = 0
    private var leftTime: Int = 0
    private var time_ini: Int = 0
    private lateinit var exerciseName: String
    private lateinit var Nextexercise: String
    private var NextRep: Int = 0
    private lateinit var intent_next: Intent
    private lateinit var time : TextView
    private var Next_exercise: Next = Next()
    private var exo = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_tracked)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        time = findViewById(R.id.HH)

        val intent = intent
        initialTime = intent.getIntExtra("Timeselection", 0).toLong()
        exerciseName = intent.getStringExtra("ExercisesName").toString()
        time_ini = intent.getIntExtra("Time_ini",0)
        exo = intent.getStringArrayListExtra("Exo") as ArrayList<String>

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        time.text = currentTime

        button_cancel= findViewById(R.id.cancel)
        button_past= findViewById(R.id.past)
        rest = findViewById(R.id.timeLeft)
        exerciseString = findViewById(R.id.exercisesName)
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

        exerciseString.text = exerciseName
        countdown = object: CountDownTimer(initialTime*1000,3){
            override fun onTick(p0: Long) {
                rest.text = "${(p0/1000).toInt()+1}"
                leftTime = (p0/1000 + 1).toInt()
            }

            override fun onFinish() {
                val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
                startActivity(intent_next)
                finish()
            }
        }
        countdown.start()


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
            rest.text = leftTime.toString()
            countdown = object: CountDownTimer((leftTime*1000).toLong(),3) {
                override fun onTick(p0: Long) {
                    rest.text = "${(p0 / 1000).toInt() + 1}"
                    leftTime = (p0 / 1000 + 1).toInt()
                }

                override fun onFinish() {
                    startActivity(intent_next)
                    finish()
                }
            }
        }
        button_past.setOnClickListener {
            startActivity(intent_next)
            finish()
            countdown.cancel()
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