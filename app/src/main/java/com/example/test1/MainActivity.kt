package com.example.test1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText

    lateinit var email_error: TextView
    lateinit var password_error: TextView

    lateinit var email_view: View
    lateinit var password_view: View

    lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        password_error = findViewById(R.id.password_error_textView)
        email_error = findViewById(R.id.email_error_textView)
        login = findViewById(R.id.login_button)
        email_view = findViewById(R.id.email_view)
        password_view = findViewById(R.id.password_view)

        val forget = findViewById<TextView>(R.id.forget)
        val signUp = findViewById<TextView>(R.id.signup)

        forget.setOnClickListener {
            val intent = Intent(this, forgetpassword::class.java)
            startActivity(intent)
        }

        signUp.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
        login.setOnClickListener {
            var email = email.text.toString()
            var password = password.text.toString()
            email_view.setBackgroundColor(Color.parseColor("#979797"))
            password_view.setBackgroundColor(Color.parseColor("#979797"))

            email_error.text = ""
            password_error.text = ""

            if (email.isEmpty()) {
                email_error.text = "Required"
                email_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (!checkEmail(email)) {
                email_error.text = "Please enter valid email"
                email_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (password.isEmpty()) {
                password_error.text = "Required"
                password_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (password.length<=7) {
                password_error.text = "Password must be atleast 8 characters"
                password_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else {

                Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun checkEmail(email: String): Boolean {

        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }

}
