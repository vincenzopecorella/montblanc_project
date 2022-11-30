package com.example.appli_watch.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.example.appli_watch.MainActivity
import com.example.appli_watch.R
import java.text.SimpleDateFormat
import java.util.*

class Menu_concierge : AppCompatActivity() {
    private lateinit var button_trainer: Button
    private lateinit var button_gym: Button
    private lateinit var button_order: Button
    private lateinit var button_adventure: Button
    private lateinit var time : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_concierge)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        button_trainer = findViewById(R.id.trainer)
        button_gym = findViewById(R.id.gym)
        button_order = findViewById(R.id.order)
        button_adventure = findViewById(R.id.adventure)

        time = findViewById(R.id.HH)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        time.text = currentTime

        val Intent_trainer : Intent =  Intent(/* packageContext = */ this,/* cls = */
            MainActivity::class.java)
        button_trainer.setOnClickListener {
            startActivity(Intent_trainer)
            finish()
        }
        val Intent_gym : Intent =  Intent(/* packageContext = */ this,/* cls = */
            MainActivity::class.java)
        button_gym.setOnClickListener {
            startActivity(Intent_gym)
            finish()
        }
        val Intent_order : Intent =  Intent(/* packageContext = */ this,/* cls = */
            MainActivity::class.java)
        button_order.setOnClickListener {
            startActivity(Intent_order)
            finish()
        }
        val Intent_adventure : Intent =  Intent(/* packageContext = */ this,/* cls = */
            MainActivity::class.java)
        button_adventure.setOnClickListener {
            startActivity(Intent_adventure)
            finish()
        }


    }
}