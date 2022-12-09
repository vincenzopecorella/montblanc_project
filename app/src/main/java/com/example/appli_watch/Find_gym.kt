package com.example.appli_watch

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.Menu.Start
import java.text.SimpleDateFormat
import java.util.*

class Find_gym : AppCompatActivity() {

    private lateinit var cancel: Button
    private lateinit var time : TextView
    private lateinit var countdown: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_gym)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        time = findViewById(R.id.HH)
        cancel = findViewById(R.id.cancel)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        time.text = currentTime

        cancel.setOnClickListener {
            val Intent_start : Intent =  Intent(/* packageContext = */ this,/* cls = */
                MainActivity::class.java)
            startActivity(Intent_start)
            finish()
        }

        val Intent_next : Intent =  Intent(/* packageContext = */ this,/* cls = */
            Find_gym2::class.java)

        countdown = object: CountDownTimer(3000,1){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                try{
                    val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))


                    startActivity(Intent_next)
                    finish()

                }catch (e: Exception){
                    print(e)
                }
            }
        }

        countdown.start()

    }
}