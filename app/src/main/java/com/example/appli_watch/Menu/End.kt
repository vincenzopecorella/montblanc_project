package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.MainActivity
import com.example.appli_watch.R
import com.example.appli_watch.exercises.DeadBug
import java.text.SimpleDateFormat
import java.util.*

class End : AppCompatActivity() {
    private lateinit var duration: TextView
    private var time_ini: Int = 0
    private lateinit var time : TextView
    private lateinit var menu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val intent = intent
        time_ini = intent.getIntExtra("Time_ini",0)

        menu = findViewById(R.id.menu)
        duration = findViewById(R.id.duration)

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
            duration.text = m+":"+s
        }
        else{
            duration.text = h+":"+m+":"+s
        }

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        time.text = currentTime

        menu.setOnClickListener {
            val Intent_menu : Intent =  Intent(/* packageContext = */ this,/* cls = */
                MainActivity::class.java)
            startActivity(Intent_menu)
            finish()
        }

    }
}