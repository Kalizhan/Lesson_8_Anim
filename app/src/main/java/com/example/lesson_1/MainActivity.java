package com.example.lesson_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText number1, number2;
    Button btnPlus, btnMinus, btnMulti, btnDivide;
    TextView tvResult;
    Animation clockwise, zoom, fade, slide, blink, moveto;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.blink:
                tvResult.startAnimation(blink);
                break;
            case R.id.clockwise:
                tvResult.startAnimation(clockwise);
                break;
            case R.id.zoom:
                tvResult.startAnimation(zoom);
                break;
            case R.id.move_to:
                tvResult.startAnimation(moveto);
                break;
            case R.id.slide:
                tvResult.startAnimation(slide);
                break;
            case R.id.fade:
                tvResult.startAnimation(fade);
                break;
        };
        return true;
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mini_calculator);
        clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        fade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        slide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        moveto = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.moveto);



        number1 = findViewById(R.id.et_number1);
        number2 = findViewById(R.id.et_number2);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMulti = findViewById(R.id.btn_multi);
        btnDivide = findViewById(R.id.btn_divide);

        tvResult = findViewById(R.id.tv_result);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
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