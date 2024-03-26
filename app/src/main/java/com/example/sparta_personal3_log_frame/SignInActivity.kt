package com.example.sparta_personal3_log_frame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    private val buttonLogin: Button by lazy { findViewById<Button>(R.id.button_login) }
    private val buttonJoin:Button by lazy { findViewById<Button>(R.id.button_joinMem) }
    private val email:EditText by lazy { findViewById<EditText>(R.id.edittext_email) }
    private val password:EditText by lazy { findViewById<EditText>(R.id.edittext_password) }
    private val REQ_SIGNUP = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener {
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            if (emailText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else if (emailText.isNotEmpty() && passwordText.isNotEmpty()) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("Email", emailText)
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        buttonJoin.setOnClickListener {
            val intent = Intent(this, SingUpActivity::class.java)
            startActivityForResult(intent, REQ_SIGNUP)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_SIGNUP) {
                email.setText(data?.getStringExtra("id"))
                password.setText(data?.getStringExtra("pw"))

                Toast.makeText(this, "${data?.getStringExtra("name")}" +
                        ", ${data?.getStringExtra("id")}" +
                        ", ${data?.getStringExtra("pw")}", Toast.LENGTH_LONG).show()
            }
        }
    }
}