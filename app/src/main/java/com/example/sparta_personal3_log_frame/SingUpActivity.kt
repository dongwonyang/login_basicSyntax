package com.example.sparta_personal3_log_frame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider

class SingUpActivity : AppCompatActivity() {
    val viewModel: SignViewModel by lazy { ViewModelProvider(this)[SignViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val buttonSingUp = findViewById<Button>(R.id.button_signUp)
        val editTextName = findViewById<EditText>(R.id.editText_name)
        val editTextEmail = findViewById<EditText>(R.id.editText_signUp_email)
        val editTextPassword = findViewById<EditText>(R.id.editText_signUp_password)

        editTextName.doAfterTextChanged {
            viewModel.inputName(it.toString())
        }

        editTextEmail.doAfterTextChanged {
            viewModel.inputId(it.toString())
        }

        editTextPassword.doAfterTextChanged {
            viewModel.inputPw(it.toString())
        }

        buttonSingUp.setOnClickListener {
            Log.d("viewModel",viewModel.userAccount.value.toString())
            if(viewModel.isAccountValid()){
                val intent = Intent()
                intent.putExtra("id", viewModel.getId())
                intent.putExtra("pw", viewModel.getPw())
                intent.putExtra("name", viewModel.getName())
                setResult(RESULT_OK, intent)
                finish()
            } else{
                Toast.makeText(this, "id email 형식, password 길이 6 이상", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
