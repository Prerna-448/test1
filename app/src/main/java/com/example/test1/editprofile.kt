package com.example.test1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.regex.Pattern

class editprofile : AppCompatActivity() {

    lateinit var full_name: EditText
    lateinit var fullname_error_textview: TextView
    lateinit var change_pwd: Button
    lateinit var change_pin: Button
    lateinit var fullname_view:View
    lateinit var sign_back_btn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofile)

        full_name = findViewById(R.id.full_name)
        fullname_error_textview = findViewById(R.id.full_name_error_textView)
        change_pwd = findViewById(R.id.change_pwd)
        change_pin = findViewById(R.id.change_pin)
        fullname_view = findViewById(R.id.full_name_view)

        fullname_error_textview = findViewById(R.id.full_name_error_textView)

        sign_back_btn = findViewById(R.id.back_button)

        sign_back_btn.setOnClickListener {
            finish()
        }

        change_pin.setOnClickListener {
            Toast.makeText(this, "clicked change pin button", Toast.LENGTH_SHORT).show()
        }

        change_pwd.setOnClickListener {
            var full_name = full_name.text.toString()
             fullname_view.setBackgroundColor(Color.parseColor("#979797"))

            fullname_error_textview.text =""

            if (full_name.isEmpty()) {
                fullname_error_textview.text = "Required"
                fullname_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (!isNameValidFormate(full_name)) {
                fullname_error_textview.text = "Please Enter Valid Name"
                fullname_view.setBackgroundColor(Color.parseColor("#FF0808"))
            } else {
                Toast.makeText(this, "clicked change password button", Toast.LENGTH_SHORT).show()
            }
        }
    }

        fun isNameValidFormate(name: String): Boolean {
            val nameREGEX = Pattern.compile("^[A-Za-z]+$");
            return nameREGEX.matcher(name.toString()).matches()
        }
    }

