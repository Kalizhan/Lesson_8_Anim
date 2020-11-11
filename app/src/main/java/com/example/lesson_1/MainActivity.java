package com.example.lesson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText number1, number2;
    Button btnPlus, btnMinus, btnMulti, btnDivide;
    TextView tvResult;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mini_calculator);

        number1 = findViewById(R.id.et_number1);
        number2 = findViewById(R.id.et_number2);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMulti = findViewById(R.id.btn_multi);
        btnDivide = findViewById(R.id.btn_divide);

        tvResult = findViewById(R.id.tv_result);

        btnPlus.setOnClickListener((View.OnClickListener) this);
        btnMinus.setOnClickListener((View.OnClickListener) this);
        btnMulti.setOnClickListener((View.OnClickListener) this);
        btnDivide.setOnClickListener((View.OnClickListener) this);
    }


    @SuppressLint("SetTextI18n")
    public void onClick(View view){
        int res = 0;

        if (view.getId() == R.id.btn_plus){
            res = Integer.parseInt(number1.getText().toString()) + Integer.parseInt(number2.getText().toString());
        } else if(view.getId() == R.id.btn_minus){
            res = Integer.parseInt(number1.getText().toString()) - Integer.parseInt(number2.getText().toString());
        } else if(view.getId() == R.id.btn_multi){
            res = Integer.parseInt(number1.getText().toString()) * Integer.parseInt(number2.getText().toString());
        } else if(view.getId() == R.id.btn_divide){
            res = Integer.parseInt(number1.getText().toString()) / Integer.parseInt(number2.getText().toString());
        }

        tvResult.setText("Result: " + res);
    }
}