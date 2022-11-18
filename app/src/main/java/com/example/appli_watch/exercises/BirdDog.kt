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
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.appli_watch.R
import com.example.appli_watch.utils.Exercise
import com.example.appli_watch.utils.RepetitionDetector


class BirdDog() : Activity(), SensorEventListener, View.OnClickListener {
    private lateinit var button_pause: Button
    private lateinit var sensorManager: SensorManager
    private lateinit var sensorManager2: SensorManager
    private lateinit var sensorManager3: SensorManager
    private lateinit var counter: TextView
    private var pause: Boolean = false
    private val repetitionTracker: RepetitionDetector = RepetitionDetector(Exercise.BIRDDOG)
    private var maxRepetitions: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.appli_watch.R.layout.activity_squats)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val intent = intent
        maxRepetitions = intent.getIntExtra("maxRepetitions", 0)


        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        counter = findViewById(R.id.counter)
        setUpSensorStuff()
        button_pause = findViewById(R.id.button_pause)
        button_pause.setOnClickListener(this)
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
            return
        }
        repetitionTracker.update(event)
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

    override fun onClick(view: View?) {
        if (pause) {
            button_pause.text = "Pause"
            pause = false
        } else {
            button_pause.text = "Play"
            pause = true
        }
    }
}