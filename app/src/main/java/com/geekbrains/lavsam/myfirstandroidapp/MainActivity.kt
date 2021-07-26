package com.geekbrains.lavsam.myfirstandroidapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText firstDigit;
    private EditText secondDigit;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digit_cheker);

        firstDigit = findViewById(R.id.first_digit);
        secondDigit = findViewById(R.id.second_digit);

        Button compareButton = findViewById(R.id.btn_compare);

        textResult = findViewById(R.id.text_result);

        compareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compareDigits();
            }
        });

    }

    private void compareDigits() {
        try {
            Integer firstValue = Integer.valueOf(firstDigit.getText().toString());

            Integer secondValue = Integer.valueOf(secondDigit.getText().toString());

            if (firstValue.equals(secondValue)) {
                textResult.setText("Equal");
            } else {
                textResult.setText("Not Equal");
            }
        } catch (NumberFormatException exception) {
            textResult.setText("Please enter a digit, damn ass!");
            Log.v("Digit Checker", "User is minimally acceptional.");
        }

    }
}