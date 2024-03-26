package com.example.sparta_personal3_log_frame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val buttonFinish = findViewById<Button>(R.id.button_home_finish)
        val textViewId = findViewById<TextView>(R.id.textView_home_id)
        val imageViewMain = findViewById<ImageView>(R.id.imageview_home_main)

        textViewId.text = intent.getStringExtra("Email")

        val rand = Random
        val getRandomInt = rand.nextInt(5)+1
        val resourceId = resources.getIdentifier("dog$getRandomInt", "drawable", packageName)
        imageViewMain.setImageResource(resourceId)

        buttonFinish.setOnClickListener {
            finish()
        }
    }
}