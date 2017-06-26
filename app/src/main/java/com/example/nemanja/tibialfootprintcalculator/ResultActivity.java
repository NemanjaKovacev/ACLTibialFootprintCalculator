package com.example.nemanja.tibialfootprintcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intentResult = getIntent();
        Float fResult = intentResult.getFloatExtra("RESULT", 0);

        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textViewResult.setText(String.valueOf(fResult) + " " + getString(R.string.square_mm));
    }
}
