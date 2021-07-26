package com.geekbrains.lavsam.myjavatokotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var firstDigit: EditText? = null
    private var secondDigit: EditText? = null
    private var textResult: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digit_cheker)
        firstDigit = findViewById(R.id.first_digit)
        secondDigit = findViewById(R.id.second_digit)
        val compareButton = findViewById<Button>(R.id.btn_compare)
        textResult = findViewById(R.id.text_result)
        compareButton.setOnClickListener { compareDigits() }
    }

    private fun compareDigits() {
        try {
            val firstValue = Integer.valueOf(firstDigit!!.text.toString())
            val secondValue = Integer.valueOf(secondDigit!!.text.toString())
            if (firstValue == secondValue) {
                textResult!!.text = "Equal"
            } else {
                textResult!!.text = "Not Equal"
            }
        } catch (exception: NumberFormatException) {
            textResult!!.text = "Please enter a digit, damn ass!"
            Log.v("Digit Checker", "User is minimally acceptional.")
        }
    }
}