package com.geekbrains.lavsam.myjavatokotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.lavsam.myjavatokotlin.data.CopyField
import com.geekbrains.lavsam.myjavatokotlin.data.Weather
import com.geekbrains.lavsam.myjavatokotlin.repository.RepositoryFieldSingle
import com.geekbrains.lavsam.myjavatokotlin.repository.RepositorySingle

class MainActivity : AppCompatActivity() {
    private lateinit var firstDigit: EditText
    private lateinit var secondDigit: EditText
    private lateinit var textResult: TextView
    private lateinit var recyclerWeather: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_digit_cheker)
        firstDigit = findViewById(R.id.first_digit)
        secondDigit = findViewById(R.id.second_digit)
        textResult = findViewById(R.id.text_result)
        val copyField: CopyField = RepositoryFieldSingle.getFields()
        firstDigit.setText(copyField.fieldFirst)
        secondDigit.setText(copyField.fieldSecond)

        val compareButton = findViewById<Button>(R.id.btn_compare)
        compareButton.setOnClickListener { compareDigits() }
        val copyButton = findViewById<Button>(R.id.btn_copy)
        copyButton.setOnClickListener { copyDigits() }

        recyclerWeather = findViewById(R.id.recyclerWeather)
        val adapter = WeatherAdapter(RepositorySingle)
        recyclerWeather.adapter = adapter

        for(i in 1..10) {
            Log.v(getString(R.string.LogTag), getString(R.string.LogMsgKotlin) + " " + i.toString())
        }

        val weatherList: List<Weather> = RepositorySingle.getWeathers()
        for(weather in weatherList) {
            Log.v(getString(R.string.LogTag), weather.town + " " + weather.temperature)
        }

        for(i in 10 downTo 1 step 2) {
            Log.v(getString(R.string.LogTag), getString(R.string.LogMsgKotlin) + " " + i.toString())
        }

        val weatherTown: String = getString(R.string.FindTown)
        for (i in weatherList.indices) {
            if (weatherList[i].town == weatherTown) {
                Log.v(getString(R.string.LogTag), weatherList[i].town + " " + weatherList[i].temperature)
                break
            }
        }

        Log.v(getString(R.string.LogTag), copyField.fieldFirst + " " + copyField.fieldSecond)
    }

    private fun copyDigits(){
        secondDigit.text = firstDigit.text
        textResult.text = getString(R.string.MsgCopied)
    }

    private fun compareDigits() {
        try {
            val firstValue = Integer.valueOf(firstDigit.text.toString())
            val secondValue = Integer.valueOf(secondDigit.text.toString())
            if (firstValue == secondValue) {
                textResult.text = getString(R.string.MsgEqual)
            } else {
                textResult.text = getString(R.string.MsgNotEqual)
            }
        } catch (exception: NumberFormatException) {
            textResult.text = getString(R.string.MsgEnterDigit)
            Log.v(getString(R.string.LogTag), getString(R.string.LogMsgUserBad))
        }
    }
}