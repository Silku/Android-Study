package com.example.mbmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BMI_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        TextView resultBmiValue = findViewById(R.id.resultBmiValue);
        TextView resultTv = findViewById(R.id.resultTv);
        //인텐트에서 넘겨 온 값 꺼내기
        Intent intent = getIntent();
        int height = intent.getIntExtra("height", 0);
        int weight = intent.getIntExtra("weight", 0);

        Log.d("TAG", "height : " + height);
        Log.d("TAG", "weight : " + weight);

        //키 - cm단위로 받았지만 bmi식에서는 m단위로 계산해야 함.
        // cm/100 하면된다.

        double bmiValue = weight / Math.pow(height/100.0, 2);
        Log.d("TAG", "bmiValue : " + bmiValue);
        String resultText = "";
        if(bmiValue < 18.5){
            resultText = "저체중입니다.";
        }else if(bmiValue < 23){
            resultText = "정상체중입니다.";
        }else if(bmiValue < 25){
            resultText = "과체중입니다.";
        }else if(bmiValue < 30){
            resultText = "경도비만입니다.";
        }else if(bmiValue < 35){
            resultText = "중정도비만입니다.";
        }else{
            resultText = "고도비만입니다.";
        }

        resultBmiValue.setText("BMI : " + bmiValue);
        resultTv.setText(resultText);

    }
}