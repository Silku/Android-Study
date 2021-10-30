package com.example.secretdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class DiaryActivity extends AppCompatActivity {

    EditText diaryEditText;

    Handler handler = new Handler(Looper.getMainLooper());
    //쓰레드 사용하는데 필요

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diaryEditText = findViewById(R.id.diaryEditText);

        //파일에 있는 값을 화면 뷰에 찍어 줘야함.
        SharedPreferences detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
        detailPreferences.getString("detail","");

        //thread 기능 구현
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("detail" , diaryEditText.getText().toString());
                editor.apply();
            }
        };

        diaryEditText.setText(detailPreferences.getString("detail","test"));
       // String data = diaryEditText.getText().toString();

        diaryEditText.addTextChangedListener(new TextWatcher() {
            //addTextChangedListener : 텍스트의 변경사항을 추적함
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //회원가입 아이디가 10자 이상 2자이하일떄
                Log.d("TAG", "diaryEditText" + diaryEditText);
                Log.d("TAG", "i : " +i);
                Log.d("TAG", "i1 : " +i1);
                //한글자씪 저장가능

                handler.removeCallbacks(runnable); //기존에 저장된거 지워줌.
                handler.postDelayed(runnable, 500);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}