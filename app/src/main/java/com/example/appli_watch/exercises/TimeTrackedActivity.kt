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
import com.example.appli_watch.MainActivity
import com.example.appli_watch.Menu.End
import com.example.appli_watch.Menu.Menu_training
import com.example.appli_watch.R
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
    private lateinit var time : TextView
    private lateinit var timepast : TextView
    private var exo = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_tracked)

        time = findViewById(R.id.HH)
        timepast = findViewById(R.id.timepast)

        val intent = intent
        initialTime = intent.getIntExtra("Timeselection", 0).toLong()
        exerciseName = intent.getStringExtra("ExercisesName").toString()
        time_ini = intent.getIntExtra("Time_ini",0)
        exo = intent.getStringArrayListExtra("Exo") as ArrayList<String>

        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    while (true) {

                        val cal = Calendar.getInstance();
                        val heure = cal.get(Calendar.HOUR)
                        val min = cal.get(Calendar.MINUTE)
                        val sec = cal.get(Calendar.SECOND)

                        val time_actuel = sec + min*60+heure*3600
                        val diff = time_actuel - time_ini
                        val diff_h = (diff/3600).toInt()
                        val diff_min = ((diff -diff_h*3600)/60).toInt()
                        val diff_sec = ((diff-diff_min*60-diff_h*3600)).toInt()

                        var h =""
                        var m =""
                        var s=""

                        if (diff_h <10){
                            h = "0"+"${diff_h}"
                        }
                        else   {
                            h = diff_h.toString()
                        }
                        if (diff_min <10){
                            m = "0"+"${diff_min}"
                        }
                        else   {
                            m = diff_min.toString()
                        }
                        if (diff_sec <10){
                            s = "0"+"${diff_sec}"
                        }
                        else   {
                            s = diff_sec.toString()
                        }

                        if(diff_h==0){
                            timepast.text = m+":"+s
                        }
                        else{
                            timepast.text = h+":"+m+":"+s
                        }

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

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

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

        var intent_next = Intent()
        if(Nextexercise=="End"){
            intent_next = Intent(this, End::class.java)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Rest"){
            intent_next = Intent(this, BreakActivity::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }

        exerciseString.text = exerciseName
        countdown = object: CountDownTimer(initialTime*1000,3){
            override fun onTick(p0: Long) {
                rest.text = "${(p0/1000).toInt()+1}"
                leftTime = (p0/1000 + 1).toInt()
            }

            override fun onFinish() {
                startActivity(intent_next)
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
                }
            }
        }
        button_past.setOnClickListener {
            startActivity(intent_next)
            countdown.cancel()
        }
        button_cancel.setOnClickListener {
            val intent_cancel = Intent(/* packageContext = */ this,/* cls = */
                MainActivity::class.java)
            startActivity(intent_cancel)
            countdown.cancel()
        }




    }


}