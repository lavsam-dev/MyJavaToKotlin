package com.geekbrains.lavsam.myjavatokotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.lavsam.myjavatokotlin.data.CopyField
import com.geekbrains.lavsam.myjavatokotlin.data.Weather
import com.geekbrains.lavsam.myjavatokotlin.repository.RepositoryFieldSingle
import com.geekbrains.lavsam.myjavatokotlin.repository.RepositorySingle

class MainActivity : AppCompatActivity() {
    private var firstDigit: EditText? = null
    private var secondDigit: EditText? = null
    private var textResult: TextView? = null
    private lateinit var recyclerWeather: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_digit_cheker)
        firstDigit = findViewById(R.id.first_digit)
        secondDigit = findViewById(R.id.second_digit)
        textResult = findViewById(R.id.text_result)
        var copyField: CopyField = RepositoryFieldSingle.getFields()
        firstDigit!!.setText(copyField.fieldFirst)
        secondDigit!!.setText(copyField.fieldSecond)

        val compareButton = findViewById<Button>(R.id.btn_compare)
        compareButton.setOnClickListener { compareDigits() }
        val copyButton = findViewById<Button>(R.id.btn_copy)
        copyButton.setOnClickListener { copyDigits() }

        recyclerWeather = findViewById(R.id.recyclerWeather)
        val adapter = WeatherAdapter(RepositorySingle)
        recyclerWeather.adapter = adapter

        for(i in 1..10) {
            Log.v("Digit Checker", "Hello Kotlin! " + i.toString())
        }

        val weatherList: List<Weather> = RepositorySingle.getWeathers()
        for(weather in weatherList) {
            Log.v("Digit Checker", weather.town + " " + weather.temperature)
        }

        for(i in 10 downTo 1 step 2) {
            Log.v("Digit Checker", "Hello Kotlin! " + i.toString())
        }

        val weatherTown: String = "Самара"
        for (i in 0 until weatherList.size) {
            if (weatherList[i].town == weatherTown) {
                Log.v("Digit Checker", weatherList[i].town + " " + weatherList[i].temperature)
                break
            }
        }

        Log.v("Digit Checker", copyField.fieldFirst + " " + copyField.fieldSecond)
    }

    private fun copyDigits(){
        secondDigit!!.setText(firstDigit!!.text)
        textResult!!.text = "Copied"
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
            textResult!!.text = "Please enter a digit!"
            Log.v("Digit Checker", "User is minimally acceptional.")
        }
    }
}