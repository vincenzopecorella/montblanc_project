package com.example.appli_watch.Menu

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appli_watch.R
import com.example.appli_watch.exercises.*
import java.text.SimpleDateFormat
import java.util.*


class Start : AppCompatActivity() {
    private lateinit var exercise_name: String
    private var maxRepetitions: Int = 0
    private lateinit var exercise: TextView
    private lateinit var start: TextView
    private lateinit var time : TextView
    private lateinit var countdown: CountDownTimer
    private var time_ini: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val intent = intent
        maxRepetitions = intent.getIntExtra("maxRepetitions", 0)
        exercise_name = intent.getStringExtra("ExercisesName").toString()

        exercise = findViewById(R.id.trainingTitle)
        start = findViewById(R.id.start)
        exercise.text = maxRepetitions.toString().plus("  ").plus(exercise_name)

        time = findViewById(R.id.HH)

        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    while (true) {
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

        val t = this

        countdown = object: CountDownTimer(3000,3){
            override fun onTick(p0: Long) {
                start.text = "${p0/1000.toInt()+1}"
            }

            override fun onFinish() {
                try{
                    val cal = Calendar.getInstance();
                    val heure_ini = cal.get(Calendar.HOUR)
                    val min_ini = cal.get(Calendar.MINUTE)
                    val sec_ini = cal.get(Calendar.SECOND)

                    time_ini = sec_ini + min_ini*60+heure_ini*3600

                    val Intent_jumpingjacks: Intent =  Intent(/* packageContext = */ t,/* cls = */
                        TimeTrackedActivity::class.java)
                    Intent_jumpingjacks.putExtra("time", 15)
                    Intent_jumpingjacks.putExtra("ExercisesName", exercise_name)
                    Intent_jumpingjacks.putExtra("Time_ini", time_ini)

                    val Intent_deadbug : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        DeadBug::class.java)
                    Intent_deadbug.putExtra("maxRepetitions", maxRepetitions)
                    Intent_deadbug.putExtra("ExercisesName", exercise_name)
                    Intent_deadbug.putExtra("Time_ini", time_ini)

                    val Intent_squats : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        Squats::class.java)
                    Intent_squats.putExtra("maxRepetitions", maxRepetitions)
                    Intent_squats.putExtra("ExercisesName", exercise_name)
                    Intent_squats.putExtra("Time_ini", time_ini)

                    val Intent_lunges : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        Lunges::class.java)
                    Intent_lunges.putExtra("maxRepetitions", maxRepetitions)
                    Intent_lunges.putExtra("ExercisesName", exercise_name)
                    Intent_lunges.putExtra("Time_ini", time_ini)

                    val Intent_birddogs : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        BirdDogs::class.java)
                    Intent_birddogs.putExtra("maxRepetitions", maxRepetitions)
                    Intent_birddogs.putExtra("ExercisesName", exercise_name)
                    Intent_birddogs.putExtra("Time_ini", time_ini)


                    if(exercise_name == "Squats"){
                        startActivity(Intent_squats)
                    }
                    if(exercise_name == "Jumping Jacks"){
                        startActivity(Intent_jumpingjacks)
                    }
                    if(exercise_name == "Dead Bugs"){
                        startActivity(Intent_deadbug)
                    }
                    if(exercise_name == "Lunges"){
                        startActivity(Intent_lunges)
                    }
                    if(exercise_name == "Bird Dogs"){
                        startActivity(Intent_birddogs)
                    }

                }catch (e: Exception){
                    print(e)
                }
            }
        }

        countdown.start()

    }
}