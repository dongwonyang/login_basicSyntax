package com.example.sparta_personal3_log_frame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.button_login)
        val buttonJoin = findViewById<Button>(R.id.button_joinMem)
        val email = findViewById<EditText>(R.id.edittext_email)
        val password = findViewById<EditText>(R.id.edittext_password)


        buttonLogin.setOnClickListener {
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            if(emailText.isEmpty() || passwordText.isEmpty()){
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else if(emailText.isNotEmpty() && passwordText.isNotEmpty()) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("Email", emailText)
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        buttonJoin.setOnClickListener {
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }
    }
}