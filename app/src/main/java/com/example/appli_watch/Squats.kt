package com.example.appli_watch

import android.app.Activity
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
import com.example.appli_watch.utils.Exercise
import com.example.appli_watch.utils.RepetitionDetector


class Squats : Activity(), SensorEventListener, View.OnClickListener {
    private lateinit var button_pause: Button
    private lateinit var sensorManager: SensorManager
    private lateinit var sensorManager2: SensorManager
    private lateinit var sensorManager3: SensorManager
    private lateinit var square: TextView
    private lateinit var square2: TextView
    private var pause: Boolean = false
    private val repetitionTracker: RepetitionDetector = RepetitionDetector(Exercise.SQUAT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_squats)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        square = findViewById(R.id.t_square)
        square2 = findViewById(R.id.t_square2)
        square2.visibility = View.INVISIBLE
        setUpSensorStuff()
        button_pause = findViewById(R.id.button_p)
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

        sensorManager3 = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager3.getDefaultSensor(Sensor.TYPE_GYROSCOPE)?.also{
            sensorManager3.registerListener(this, it,SensorManager.SENSOR_DELAY_FASTEST, SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (pause){
            return
        }
        repetitionTracker.update(event)
        square.text = "Squats :\n ${repetitionTracker.getNumberOfRepetitions()}, ${repetitionTracker.corr}"

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        return
    }

    override fun onDestroy() {
        sensorManager.unregisterListener(this)
        super.onDestroy()
    }

    override fun onClick(view: View?) {
        if(pause){
            square.visibility = View.VISIBLE
            square2.visibility = View.INVISIBLE
            button_pause.text = "Pause"
            pause = false
            Toast.makeText(this@Squats, "Play", Toast.LENGTH_SHORT).show()
        } else {
            square.visibility = View.INVISIBLE
            square2.visibility = View.VISIBLE
            button_pause.text = "Play"
            square2.text = "Squats :\n ${repetitionTracker.getNumberOfRepetitions()}"
            pause = true
            Toast.makeText(this@Squats, "Pause", Toast.LENGTH_SHORT).show()
        }
    }
}