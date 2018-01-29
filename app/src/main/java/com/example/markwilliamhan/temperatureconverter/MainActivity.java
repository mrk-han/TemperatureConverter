package com.example.markwilliamhan.temperatureconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    private RadioButton celsiusButton;
    private RadioButton fahrenheitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.inputValue);
        celsiusButton = (RadioButton) findViewById(R.id.radioButton1);
        fahrenheitButton = (RadioButton) findViewById(R.id.radioButton2);
    }


    public void convertTemperature(View view) {
        switch (view.getId()) {
            case R.id.calculateButton1:



                if (text.getText().toString().equals("") || text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {
                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                } else {
                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }
                break;
        }
    }


    // This method resets the app to how it first is when it opens (reset everything)
    public void clearText(View view) {
        text.setText("");
        celsiusButton.setChecked(true);


    }


}
