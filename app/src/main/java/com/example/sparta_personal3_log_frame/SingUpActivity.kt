package com.example.sparta_personal3_log_frame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SingUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val buttonSingUp = findViewById<Button>(R.id.button_signUp)
        val editTextName = findViewById<EditText>(R.id.editText_name)
        val editTextEmail = findViewById<EditText>(R.id.editText_signUp_email)
        val editTextPassword = findViewById<EditText>(R.id.editText_signUp_password)

        buttonSingUp.setOnClickListener {
            val nameText = editTextName.text.toString()
            val emailText = editTextEmail.text.toString()
            val passwordText = editTextPassword.text.toString()

            if(nameText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else if(nameText.isNotEmpty() && emailText.isNotEmpty() && passwordText.isNotEmpty()){
//                finish()
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("email", emailText)
                intent.putExtra("password", passwordText)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }
    }
}