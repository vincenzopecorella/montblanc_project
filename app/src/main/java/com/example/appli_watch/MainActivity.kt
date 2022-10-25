package com.example.appli_watch

import android.app.Activity
import android.os.Bundle
import com.example.appli_watch.databinding.ActivityMainBinding
import android.content.Intent
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : Activity() {
    private lateinit var button_s: Button
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button_s = findViewById(R.id.button_squats)

        val monIntent : Intent =  Intent(/* packageContext = */ this,/* cls = */
            start_squats::class.java)
        button_s.setOnClickListener {
           startActivity(monIntent)
        }
    }
}