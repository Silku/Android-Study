package com.example.myactivity_1;


// 기본적으로 가져다 쓸 것을 가지고 온다.
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG", "onCreate 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy 호출");
    }
}