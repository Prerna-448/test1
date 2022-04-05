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

class forgetpassword : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var email_error:TextView
    lateinit var send: Button
    lateinit var email_view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgetpassword)

        email=findViewById(R.id.email)
        send=findViewById(R.id.send_pwd)
        email_error=findViewById(R.id.email_error_textView)
        email_view = findViewById(R.id.email_view)

        val Editprofile = findViewById<TextView>(R.id.Edit_profile)

        Editprofile.setOnClickListener{
            val intent = Intent(this,editprofile::class.java)
            startActivity(intent)
        }

        send.setOnClickListener {
            var email = email.text.toString()
            email_view.setBackgroundColor(Color.parseColor("#979797"))

            email_error.text = ""

            if (email.isEmpty()) {
                email_error.text = "Required"
                email_view.setBackgroundColor(Color.parseColor("#FF0808"))
            } else if (!checkEmail(email)) {
                email_error.text = "Please enter valid email"
                email_view.setBackgroundColor(Color.parseColor("#FF0808"))
            }else{
                Toast.makeText(this,"successfull", Toast.LENGTH_SHORT).show()
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