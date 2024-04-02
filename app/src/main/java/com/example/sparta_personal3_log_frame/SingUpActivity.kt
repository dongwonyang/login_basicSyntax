package com.example.sparta_personal3_log_frame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        val listEditText = listOf(
            findViewById<EditText>(R.id.editText_name),
            findViewById<EditText>(R.id.editText_signUp_email),
            findViewById<EditText>(R.id.editText_signUp_password)
        )

        listEditText.forEachIndexed { index, editText ->
            editText.doAfterTextChanged {
                viewModel.inputToType(index, editText.text.toString())
                val warningTextView = findViewById<TextView>(when (index) {
                    0 -> R.id.tv_warningName
                    1 -> R.id.tv_warningEmail
                    2 -> R.id.tv_warningPassword
                    else -> return@doAfterTextChanged
                })

                if (!viewModel.isAccountValidList()[index]) {
                    warningTextView.visibility = View.VISIBLE
                } else {
                    warningTextView.visibility = View.INVISIBLE
                }
            }
        }



        buttonSingUp.setOnClickListener {
            Log.d("viewModel", viewModel.userAccount.value.toString())
            if (viewModel.isAccountValid()) {
                val intent = Intent()
                intent.putExtra("id", viewModel.getId())
                intent.putExtra("pw", viewModel.getPw())
                intent.putExtra("name", viewModel.getName())
                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, "id email 형식, password 길이 6 이상", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
