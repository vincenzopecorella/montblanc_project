package com.example.appli_watch

import android.app.Activity
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import kotlin.math.pow
import kotlin.math.sqrt


class squats : Activity(), SensorEventListener, View.OnClickListener {
    private lateinit var button_pause: Button
    private lateinit var sensorManager: SensorManager
    private lateinit var sensorManager2: SensorManager
    private lateinit var square: TextView
    private lateinit var square2: TextView
    private var av: Float = 0.0f
    private var a1: Float = 0.0f
    private var a2: Float = 0.0f
    private var a3: Float = 0.0f
    private var gt: Float = 0.0f
    private var g1: Float = 0.0f
    private var g2: Float = 0.0f
    private var g3: Float = 0.0f
    private var timestamp: Float = 0.0f
    private var t: Float = 0.0f
    private var tw: Float= 0.0f
    private var tlim: Float = 0.2f
    private var tlim2: Float = 0.7f
    private var dT: Float = 0.0f
    private var count: Int = 0
    private var count_memoire: Int = 0
    private var NS2S: Float = 1.0f / 1000000000.0f
    private var tz1: Float = 0.0f
    private var tz2: Float = 0.0f
    private var tz3: Float = 0.0f
    private var z1: Float = 0.0f
    private var z2: Float = 0.0f
    private var z3: Float = 0.0f
    private var listz1: MutableList<List<Float>> = mutableListOf()
    private var listz2: MutableList<List<Float>> = mutableListOf()
    private var listz3: MutableList<List<Float>> = mutableListOf()
    private var limmax: Float = 0.7f
    private var limmin: Float = -0.5f
    private var minz1: Float=0.0f
    private var minz3: Float=0.0f
    private var maxz2: Float=0.0f
    private var dz2: Float=0.0f
    private var dt4: Float=0.0f
    private var dt5: Float=0.0f
    private var zz1: Float=0.0f
    private var zz2: Float=0.0f
    private var pause: Boolean = false

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
            sensorManager.registerListener(this, it,SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_FASTEST)
        }

        sensorManager2 = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager2.getDefaultSensor(Sensor.TYPE_GRAVITY)?.also{
            sensorManager2.registerListener(this, it,SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type == Sensor.TYPE_LINEAR_ACCELERATION){
            if (timestamp != 0.0f) {
                dT = (event.timestamp.toFloat() - timestamp)*NS2S
                val ax = event.values[0]
                val ay = event.values[1]
                val az = event.values[2]
                a1=ax
                a2=ay
                a3 = az
                t += dT
                tw += dT
            }
            timestamp = event.timestamp.toFloat()
        }
        if(event?.sensor?.type == Sensor.TYPE_GRAVITY){
            val gx = event.values[0]
            val gy = event.values[1]
            val gz = event.values[2]
            g1=gx
            g2=gy
            g3=gz
            gt= sqrt(g1.pow(2)+g2.pow(2)+g3.pow(2))
        }

        av = a1*g1/gt + a2*g2/gt + a3*g3/gt

        if(tw>2){
            z1=0f
            z2=0f
            z3=0f
            listz1 = mutableListOf()
            listz2 = mutableListOf()
            listz3 = mutableListOf()
        }
        if((z1==0.0f && z2==0.0f && z3==0.0f) && av<limmin){
            z1 = 1f
            tw = 0f
            var l: List<Float> = listOf(av,t)
            listz1.add(l)
        }
        else if((z1==1f && z2==0f && z3==0.0f) && av<limmin) {
            tw = 0f
            var l: List<Float> = listOf(av,t)
            listz1.add(l)
        }
        else if((z1==1f && z2==0.0f && z3==0.0f) && av>limmax){
            z2 = 1f
            tw = 0f
            var l: List<Float> = listOf(av,t)
            listz2.add(l)
        }
        else if((z1==1f && z2==1f && z3==0.0f) && av>limmax){
            tw = 0f
            var l: List<Float> = listOf(av,t)
            listz2.add(l)
        }
        else if((z1==1f && z2==1f && z3==0.0f)&&av<limmin) {
            z3 = 1f
            tw = 0f
            var l: List<Float> = listOf(av, t)
            listz3.add(l)
        }
        else if((z1==1f && z2==1f && z3==1f)&&av<limmin) {
            tw = 0f
            var l: List<Float> = listOf(av, t)
            listz3.add(l)
        }
        else if((z1==1f && z2==1f && z3==1f)&&av>limmin) {
            listz1.sortBy { it[0] }
            listz2.sortBy { it[0] }
            listz3.sortBy { it[0] }

            minz1 =  listz1[0][0]
            tz1 = listz1[0][1]
            minz3 =  listz3[0][0]
            tz3 = listz3[0][1]
            maxz2 =  listz2[listz2.size-1][0]
            tz2 = listz2[listz2.size-1][1]
            zz1 = minz1
            zz2 = maxz2
            var dt1: Float = tz2-tz1
            var dt2: Float = tz3-tz1
            var dz: Float = maxz2 - minz1
            dz2 = dz
            dt4 = dt1
            dt5 = dt2
            if(dz>15f){
                if(dt1>0.2 && dt2>0.6){
                    count += 1
                }
            }
            else if (dz<15f && dz> 5f){
                if(dt1>0.4 && dt2>0.7){
                    count += 1
                }
            }
            else if (dz<5 && dz>2){
                if(dt1>0.8 && dt2>1.5){
                    count += 1
                }
            }
            else if (dz<2 && dz>0){
                if(dt1>1.1 && dt2>2){
                    count += 1
                }
            }
//            square.text = "z1 = $minz1 \n t1 = $tz1 \n z2 = $maxz2 \n t2 = $tz2 \n z3 = $minz3 \n t3 = $tz3"
            z1=1f
            z2=0f
            z3=0f
            listz2 = mutableListOf()
//            listz1 = mutableListOf()
            listz1 = listz3
            listz3 = mutableListOf()
        }
  //      square.text = "Squats :\n $count"
        square.text = "Squats :\n $count \n $zz1 \n $zz2 \n $dz2 \n $dt4 \n $dt5"

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
            count = count_memoire
            button_pause.text = "Pause"
            pause = false
            Toast.makeText(this@squats, "Play", Toast.LENGTH_SHORT).show()
        } else {
            square.visibility = View.INVISIBLE
            square2.visibility = View.VISIBLE
            count_memoire = count
            button_pause.text = "Play"
            square2.text = "Squats :\n $count_memoire"
            pause = true
            Toast.makeText(this@squats, "Pause", Toast.LENGTH_SHORT).show()
        }
    }
}