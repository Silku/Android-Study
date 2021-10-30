package com.example.mbmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText heightEt = findViewById(R.id.heightEt);
        EditText weightEt = findViewById(R.id.weightEt);
        Button isOk = findViewById(R.id.isOk);

        isOk.setOnClickListener(view -> {
            if(heightEt.getText().length() < 1 || weightEt.length() < 1){
                Toast.makeText(this, "빈값이 있습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            int height = Integer.parseInt(heightEt.getText().toString());
            int weight = Integer.parseInt(weightEt.getText().toString());

            Intent intent = new Intent(this, BMI_result.class);
            intent.putExtra("height", height);
            intent.putExtra("weight", weight);

            //인텐트 플래그 예시코드 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}