package com.example.test1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import java.util.regex.Pattern

class signup : AppCompatActivity() {
    lateinit var sign_back_btn: ImageView
    lateinit var first_name: EditText
    lateinit var last_name: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var sign_up: Button
    lateinit var check_box: CheckBox
    lateinit var terms_and_condition: TextView

    lateinit var first_name_error: TextView
    lateinit var last_name_error: TextView
    lateinit var email_error: TextView
    lateinit var password_error: TextView

    lateinit var firstname_view: View
    lateinit var lastname_view: View
    lateinit var email_view: View
    lateinit var password_view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        first_name = findViewById(R.id.first_name)
        last_name = findViewById(R.id.last_name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        sign_up = findViewById(R.id.signup)
        check_box = findViewById(R.id.checkbox)
        terms_and_condition = findViewById(R.id.terms_condition)

        first_name_error = findViewById(R.id.first_name_error_textView)
        last_name_error = findViewById(R.id.last_name_error_textView)
        email_error = findViewById(R.id.email_error_textView)
        password_error = findViewById(R.id.password_error_textView)

        firstname_view = findViewById(R.id.first_name_view)
        lastname_view = findViewById(R.id.last_name_view)
        email_view = findViewById(R.id.email_view)
        password_view = findViewById(R.id.password_view)

        sign_back_btn = findViewById(R.id.back_button)

        sign_back_btn.setOnClickListener {
            finish()
        }

        terms_and_condition.setOnClickListener {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
        }
        sign_up.setOnClickListener {

            var first_name = first_name.text.toString()
            var last_name = last_name.text.toString()
            var email = email.text.toString()
            var password = password.text.toString()


            firstname_view.setBackgroundColor(Color.parseColor("#979797"))
            lastname_view.setBackgroundColor(Color.parseColor("#979797"))
            email_view.setBackgroundColor(Color.parseColor("#979797"))
            password_view.setBackgroundColor(Color.parseColor("#979797"))

            first_name_error.text = ""
            last_name_error.text = ""
            email_error.text = ""
            password_error.text = ""

            if (first_name == "") {
                first_name_error.isVisible = true
                first_name_error.text = "Required"
                firstname_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (first_name.length < 2) {
                first_name_error.isVisible = true
                first_name_error.text = "Not Valid"
                firstname_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (!isNameValidFormate(first_name)) {
                first_name_error.isVisible = true
                first_name_error.text = "Please Enter Valid First Name"
                firstname_view.setBackgroundColor(Color.parseColor("#FF0808"))


            } else if (last_name == "") {
                last_name_error.isVisible = true
                last_name_error.text = "Required"
                lastname_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (last_name.length < 2) {
                last_name_error.isVisible = true
                last_name_error.text = "Not Valid"
                lastname_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (!isNameValidFormate(last_name)) {
                last_name_error.isVisible = true
                last_name_error.text = "Please Enter Valid Last Name"
                lastname_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else  if (email.isEmpty()) {
                email_error.text = "Required"
                email_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (!checkEmail(email)) {
                email_error.text = "Please enter valid email"
                email_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (password.isEmpty()) {
                password_error.text = "Required"
                password_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (!isValidPasswordFormat(password)) {
                password_error.text = "Please Enter Valid Password"
                password_view.setBackgroundColor(Color.parseColor("#FF0808"))

            } else if (check_box.isChecked == true) {
                Toast.makeText(this, "Successfull", Toast.LENGTH_SHORT).show()


            } else if (check_box.isChecked == false) {
                Toast.makeText(this, "Please accept the terms and condition", Toast.LENGTH_SHORT).show()


            //} else {
              //  Toast.makeText(this, "Successfully", Toast.LENGTH_SHORT).show()

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


    fun isValidPasswordFormat(password: String): Boolean {
        val passwordREGEX = Pattern.compile(
            "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$"
        );
        return passwordREGEX.matcher(password).matches()

    }

    fun isNameValidFormate(name: String): Boolean {
        val nameREGEX = Pattern.compile("^[A-Za-z]+$");
        return nameREGEX.matcher(name).matches()
    }
}