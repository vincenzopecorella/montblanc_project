package com.example.appli_watch.exercises

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.appli_watch.MainActivity
import com.example.appli_watch.Menu.End
import com.example.appli_watch.R
import com.example.appli_watch.utils.Exercise
import com.example.appli_watch.utils.Next
import com.example.appli_watch.utils.RepetitionDetector
import java.util.*


class Squats() : Activity(), SensorEventListener, View.OnClickListener {
    private lateinit var button_pause: Button
    private lateinit var button_play: Button
    private lateinit var button_cancel: Button
    private lateinit var button_past: Button
    private lateinit var sensorManager: SensorManager
    private lateinit var sensorManager2: SensorManager
    private lateinit var counter: TextView
    private lateinit var exercise: TextView
    private var pause: Boolean = false
    private val repetitionTracker: RepetitionDetector = RepetitionDetector(Exercise.SQUAT)
    private var maxRepetitions: Int = 0
    private lateinit var exercise_name: String
    private var time_ini: Int = 0
    private lateinit var intent_next: Intent
    private lateinit var Nextexercise: String
    private var NextRep: Int = 0
    private lateinit var time : TextView
    private var Next_exercise: Next = Next()
    private lateinit var rep : TextView
    private var exo = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.appli_watch.R.layout.activity_all_exercises)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val intent = intent
        maxRepetitions = intent.getIntExtra("maxRepetitions", 0)
        exercise_name = intent.getStringExtra("ExercisesName").toString()
        time_ini = intent.getIntExtra("Time_ini",0)
        exo = intent.getStringArrayListExtra("Exo") as ArrayList<String>

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        counter = findViewById(R.id.counter)
        exercise = findViewById(R.id.trainingTitle)
        exercise.text = exercise_name
        setUpSensorStuff()

        time = findViewById(R.id.HH)
        rep = findViewById(R.id.NbRep)

        val sdf = java.text.SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        time.text = currentTime

        rep.text = "${maxRepetitions}"

        NextRep = exo.get(2).toInt()
        Nextexercise = exo.get(1)
        exo.removeAt(1)
        exo.removeAt(1)
        val n = exo.get(0).toInt()-2
        exo.set(0,"${n}")

        intent_next= Next_exercise.getNextExercise(this,Nextexercise,NextRep,time_ini)
        intent_next.putExtra("Exo",exo)

        button_cancel= findViewById(R.id.cancel)
        button_past= findViewById(R.id.past)
        button_pause = findViewById(R.id.button_pause)
        button_play = findViewById(R.id.play)

        button_play.setOnClickListener {
            button_pause.visibility=android.view.View.VISIBLE
            button_pause.isClickable=true
            button_play.visibility=android.view.View.INVISIBLE
            button_play.isClickable=false
            pause=false

        }

        button_pause.setOnClickListener {
            button_pause.visibility = android.view.View.INVISIBLE
            button_pause.isClickable = false
            button_play.visibility = android.view.View.VISIBLE
            button_play.isClickable = true
            pause=true

        }
        button_past.setOnClickListener {
            startActivity(intent_next)
            finish()
        }
        button_cancel.setOnClickListener {
            val intent_cancel = Intent(/* packageContext = */ this,/* cls = */
                MainActivity::class.java)
            startActivity(intent_cancel)
        }
    }

    private fun setUpSensorStuff(){
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)?.also{
            sensorManager.registerListener(this, it,SensorManager.SENSOR_DELAY_GAME, SensorManager.SENSOR_DELAY_FASTEST)
        }

        sensorManager2 = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager2.getDefaultSensor(Sensor.TYPE_GRAVITY)?.also{
            sensorManager2.registerListener(this, it,SensorManager.SENSOR_DELAY_GAME, SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (pause){
            repetitionTracker.startTime = 0L
            repetitionTracker.pointCount = 0
            return
        }
        repetitionTracker.update(event)

        counter.text = "${repetitionTracker.getNumberOfRepetitions()}"
        if(repetitionTracker.getNumberOfRepetitions() >= maxRepetitions ){
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
            sensorManager.unregisterListener(this)
            sensorManager2.unregisterListener(this)
            startActivity(intent_next)
            finish()
        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        return
    }

    override fun onDestroy() {
        sensorManager.unregisterListener(this)
        sensorManager2.unregisterListener(this)
        super.onDestroy()
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}