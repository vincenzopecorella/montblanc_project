package com.example.appli_watch.Menu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appli_watch.R
import com.example.appli_watch.exercises.*
import com.example.appli_watch.utils.Next
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
    private var NextRep: Int = 0
    private lateinit var intent_next: Intent
    private var Next_exercise: Next = Next()
    private var exo = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val intent = intent
        maxRepetitions = intent.getIntExtra("maxRepetitions", 0)
        timeselect = intent.getIntExtra("Timeselection", 0)
        exercise_name = intent.getStringExtra("ExercisesName").toString()
        exo = intent.getStringArrayListExtra("Exo") as ArrayList<String>

        exercise = findViewById(R.id.trainingTitle)
        start = findViewById(R.id.start)

        if(maxRepetitions==0){
            exercise.text = timeselect.toString().plus("s   ").plus(exercise_name)
            NextRep =  timeselect
        }
        else{
            exercise.text = maxRepetitions.toString().plus("  ").plus(exercise_name)
            NextRep = maxRepetitions
        }

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        time.text = currentTime

        val context = this

        countdown = object: CountDownTimer(3000,1){
            override fun onTick(p0: Long) {
                start.text = "${p0/1000.toInt()+1}"
            }

            override fun onFinish() {
                try{
                    start.text = "Go"
                    val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))

                    val cal = Calendar.getInstance();
                    val heure_ini = cal.get(Calendar.HOUR)
                    val min_ini = cal.get(Calendar.MINUTE)
                    val sec_ini = cal.get(Calendar.SECOND)

                    time_ini = sec_ini + min_ini*60+heure_ini*3600

                    intent_next= Next_exercise.getNextExercise(context,exercise_name,NextRep,time_ini)
                    intent_next.putExtra("Exo",exo)
                    startActivity(intent_next)
                    finish()

                }catch (e: Exception){
                    print(e)
                }
            }
        }

        countdown.start()

    }
}