package com.example.myactivity_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class Intent_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        //값을 꺼내는 방법
        int number1 = getIntent().getIntExtra("number1", 0);
        int number2 = getIntent().getIntExtra("number2", 0);
        int sum = number1 + number2;
        Log.d("TAG", ": number1");
        Log.d("TAG", ": number2");

        Button button2 = findViewById(R.id.button2);
        button2.setText(String.valueOf(sum));

        //버튼 클릭시다시 돌아가게 하기 --> Intent_1으로 다시 결과값을 가지고 가게한다.
        button2.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", sum);
            //결과값을 세팅
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });
    }
}