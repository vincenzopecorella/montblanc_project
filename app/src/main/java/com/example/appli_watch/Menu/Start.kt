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
import kotlin.collections.ArrayList


class Start : AppCompatActivity() {
    private lateinit var exercise_name: String
    private var maxRepetitions: Int = 0
    private var timeselect: Int = 0
    private lateinit var exercise: TextView
    private lateinit var start: TextView
    private lateinit var time : TextView
    private lateinit var countdown: CountDownTimer
    private var time_ini: Int = 0
    private var exo = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val intent = intent
        maxRepetitions = intent.getIntExtra("maxRepetitions", 0)
        timeselect = intent.getIntExtra("Timeselection", 0)
        exercise_name = intent.getStringExtra("ExercisesName").toString()
        exo = intent.getStringArrayListExtra("Exo") as ArrayList<String>

        exercise = findViewById(R.id.trainingTitle)
        start = findViewById(R.id.start)

        if(maxRepetitions==0){
            exercise.text = timeselect.toString().plus("s   ").plus(exercise_name)
        }
        else{
            exercise.text = maxRepetitions.toString().plus("  ").plus(exercise_name)
        }

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
                        JumpingJacks::class.java)
                    Intent_jumpingjacks.putExtra("maxRepetitions", maxRepetitions)
                    Intent_jumpingjacks.putExtra("ExercisesName", exercise_name)
                    Intent_jumpingjacks.putExtra("Time_ini", time_ini)
                    Intent_jumpingjacks.putExtra("Exo",exo)

                    val Intent_deadbug : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        DeadBug::class.java)
                    Intent_deadbug.putExtra("maxRepetitions", maxRepetitions)
                    Intent_deadbug.putExtra("ExercisesName", exercise_name)
                    Intent_deadbug.putExtra("Time_ini", time_ini)
                    Intent_deadbug.putExtra("Exo",exo)

                    val Intent_squats : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        Squats::class.java)
                    Intent_squats.putExtra("maxRepetitions", maxRepetitions)
                    Intent_squats.putExtra("ExercisesName", exercise_name)
                    Intent_squats.putExtra("Time_ini", time_ini)
                    Intent_squats.putExtra("Exo",exo)

                    val Intent_lunges : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        Lunges::class.java)
                    Intent_lunges.putExtra("maxRepetitions", maxRepetitions)
                    Intent_lunges.putExtra("ExercisesName", exercise_name)
                    Intent_lunges.putExtra("Time_ini", time_ini)
                    Intent_lunges.putExtra("Exo",exo)

                    val Intent_birddogs : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        BirdDogs::class.java)
                    Intent_birddogs.putExtra("maxRepetitions", maxRepetitions)
                    Intent_birddogs.putExtra("ExercisesName", exercise_name)
                    Intent_birddogs.putExtra("Time_ini", time_ini)
                    Intent_birddogs.putExtra("Exo",exo)

                    val Intent_push : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        TimeTrackedActivity::class.java)
                    Intent_push.putExtra("Timeselection", timeselect)
                    Intent_push.putExtra("ExercisesName", exercise_name)
                    Intent_push.putExtra("Time_ini", time_ini)
                    Intent_push.putExtra("Exo",exo)

                    val Intent_sit : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        BirdDogs::class.java)
                    Intent_sit.putExtra("maxRepetitions", maxRepetitions)
                    Intent_sit.putExtra("ExercisesName", exercise_name)
                    Intent_sit.putExtra("Time_ini", time_ini)
                    Intent_sit.putExtra("Exo",exo)

                    val Intent_board : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        TimeTrackedActivity::class.java)
                    Intent_board.putExtra("Timeselection", timeselect)
                    Intent_board.putExtra("ExercisesName", exercise_name)
                    Intent_board.putExtra("Time_ini", time_ini)
                    Intent_board.putExtra("Exo",exo)

                    val Intent_kicks : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        TimeTrackedActivity::class.java)
                    Intent_kicks.putExtra("Timeselection", timeselect)
                    Intent_kicks.putExtra("ExercisesName", exercise_name)
                    Intent_kicks.putExtra("Time_ini", time_ini)
                    Intent_kicks.putExtra("Exo",exo)

                    val Intent_heel : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        TimeTrackedActivity::class.java)
                    Intent_heel.putExtra("Timeselection", timeselect)
                    Intent_heel.putExtra("ExercisesName", exercise_name)
                    Intent_heel.putExtra("Time_ini", time_ini)
                    Intent_heel.putExtra("Exo",exo)

                    val Intent_dips : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        TimeTrackedActivity::class.java)
                    Intent_dips.putExtra("Timeselection", timeselect)
                    Intent_dips.putExtra("ExercisesName", exercise_name)
                    Intent_dips.putExtra("Time_ini", time_ini)
                    Intent_dips.putExtra("Exo",exo)

                    val Intent_climb : Intent =  Intent(/* packageContext = */ t,/* cls = */
                        TimeTrackedActivity::class.java)
                    Intent_climb.putExtra("Timeselection", timeselect)
                    Intent_climb.putExtra("ExercisesName", exercise_name)
                    Intent_climb.putExtra("Time_ini", time_ini)
                    Intent_climb.putExtra("Exo",exo)


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
                    if(exercise_name == "Push Ups"){
                        startActivity(Intent_push)
                    }
                    if(exercise_name == "Sit Ups"){
                        startActivity(Intent_sit)
                    }
                    if(exercise_name == "Board"){
                        startActivity(Intent_board)
                    }
                    if(exercise_name == "High Knees"){
                        startActivity(Intent_kicks)
                    }
                    if(exercise_name == "Butt Kicks"){
                        startActivity(Intent_heel)
                    }
                    if(exercise_name == "Dips"){
                        startActivity(Intent_dips)
                    }
                    if(exercise_name == "Climbers"){
                        startActivity(Intent_climb)
                    }

                }catch (e: Exception){
                    print(e)
                }
            }
        }

        countdown.start()

    }
}