package com.example.sparta_personal3_log_frame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val buttonFinish = findViewById<Button>(R.id.button_home_finish)
        val textViewId = findViewById<TextView>(R.id.textView_home_id)

        textViewId.text = intent.getStringExtra("Email")

        buttonFinish.setOnClickListener {
            finish()
        }
    }
}