package com.example.appli_watch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class Find_gym2 : AppCompatActivity() {
    private lateinit var cancel: Button
    private lateinit var time : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_gym2)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        time = findViewById(R.id.HH)
        cancel = findViewById(R.id.cancel)

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        time.text = currentTime

        cancel.setOnClickListener {
            val Intent_map : Intent =  Intent(/* packageContext = */ this,/* cls = */
                Map::class.java)
            startActivity(Intent_map)
            finish()
        }

    }
}