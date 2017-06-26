package com.example.nemanja.tibialfootprintcalculator;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAP;
    private EditText editTextML;
    private Button buttonCalculate;
    private float floatResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAP = (EditText) findViewById(R.id.editTextAP);
        editTextML = (EditText) findViewById(R.id.editTextML);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                    Float ap = Float.parseFloat(editTextAP.getText().toString());
                    Float ml = Float.parseFloat(editTextML.getText().toString());
                    floatResult = (float) (7.585 * ap - 0.179 * ml - 207.319);

                    intent.putExtra("RESULT", floatResult);
                    startActivity(intent);

                } catch (Exception e) {
                    messageBox();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        editTextAP.setText("");
        editTextML.setText("");
    }

    private void messageBox() {
        AlertDialog.Builder messageBox = new AlertDialog.Builder(this);
        messageBox.setTitle(R.string.input_missing);
        messageBox.setMessage(R.string.enter_missing_input);
        messageBox.setCancelable(false);
        messageBox.setPositiveButton(R.string.ok, null);
        messageBox.show();
    }
}
