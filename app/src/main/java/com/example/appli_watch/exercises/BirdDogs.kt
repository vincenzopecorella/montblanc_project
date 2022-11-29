package com.example.appli_watch.exercises

import android.app.Activity
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.appli_watch.MainActivity
import com.example.appli_watch.Menu.End
import com.example.appli_watch.R
import com.example.appli_watch.utils.Exercise
import com.example.appli_watch.utils.RepetitionDetector
import java.text.SimpleDateFormat
import java.util.*


class BirdDogs() : Activity(), SensorEventListener, View.OnClickListener {
    private lateinit var button_pause: Button
    private lateinit var button_play: Button
    private lateinit var button_cancel: Button
    private lateinit var button_past: Button
    private lateinit var sensorManager: SensorManager
    private lateinit var sensorManager2: SensorManager
    private lateinit var counter: TextView
    private lateinit var exercise: TextView
    private var pause: Boolean = false
    private var maxCorr: Double = 0.0
    private val repetitionTracker: RepetitionDetector = RepetitionDetector(Exercise.BIRD_DOG)
    private var maxRepetitions: Int = 0
    private lateinit var exercise_name: String
    private var time_ini: Int = 0
    private lateinit var intent_next: Intent
    private lateinit var Nextexercise: String
    private var NextRep: Int = 0
    private lateinit var time : TextView
    private lateinit var timepast : TextView
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
        timepast = findViewById(R.id.timepast)
        rep = findViewById(R.id.NbRep)

        rep.text = "${maxRepetitions}"


        NextRep = exo.get(2).toInt()
        Nextexercise = exo.get(1)
        exo.removeAt(1)
        exo.removeAt(1)
        val n = exo.get(0).toInt()-2
        exo.set(0,"${n}")

        if(Nextexercise=="End"){
            intent_next = Intent(this, End::class.java)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Rest") {
            intent_next = Intent(this, BreakActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo", exo)
        }
        else if(Nextexercise=="Squats"){
            intent_next = Intent(this, Squats::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Jumping Jacks"){
            intent_next = Intent(this, JumpingJacks::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Dead Bugs"){
            intent_next = Intent(this, DeadBug::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Lunges"){
            intent_next = Intent(this, Lunges::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Bird Dogs"){
            intent_next = Intent(this, BirdDogs::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Sit Ups"){
            intent_next = Intent(this, BirdDogs::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Push Ups"){
            intent_next = Intent(this, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Board"){
            intent_next = Intent(this, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="High Knees"){
            intent_next = Intent(this, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Butt Kicks"){
            intent_next = Intent(this, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Dips"){
            intent_next = Intent(this, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Climbers"){
            intent_next = Intent(this, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else if(Nextexercise=="Arm Circles"){
            intent_next = Intent(this, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
            intent_next.putExtra("Exo",exo)
        }
        else{
            intent_next = Intent(this, MainActivity::class.java)
        }


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
        }
        button_cancel.setOnClickListener {
            val intent_cancel = Intent(/* packageContext = */ this,/* cls = */
                MainActivity::class.java)
            startActivity(intent_cancel)
        }

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
        if(repetitionTracker.corr > maxCorr){
            maxCorr = repetitionTracker.corr
        }
        counter.text = "${repetitionTracker.getNumberOfRepetitions()}"
        if(repetitionTracker.getNumberOfRepetitions() >= maxRepetitions ){
            val intent = Intent()
            setResult(RESULT_OK, intent)
            finish()
        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        return
    }

    override fun onDestroy() {
        sensorManager.unregisterListener(this)
        super.onDestroy()
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}