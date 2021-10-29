package com.example.myactivity_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActivityListener extends AppCompatActivity {

    public final static String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);

        TextView tvHello = findViewById(R.id.tvHello);

        //이벤트 리스너 , 익명함수, 익명 객체 관련임
        //이벤트 리스너에 등록하면 -> 운영체제에 요청 : 클릭하는 요청을 듣고 있겠다 -> 클릭하면 작성한 콜백함수를 실행
        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"클릭되었습니다.");
                Log.d(TAG, view.getId() + "클릭되었습니다.");
                Log.d(TAG,view.getTag() + "클릭되었습니다.");

            }
        });

        //람다 표현식
        tvHello.setOnClickListener(view -> {
            Log.d(TAG,"클릭되었습니다.람다");
            Log.d(TAG, view.getId() + "클릭되었습니다. 람다");
            Log.d(TAG,view.getTag() + "클릭되었습니다. 람쥐");
        });

        //이벤트 리스너 종류 -> 많음

        //한줄짜리는 아래와 같이 작성가능, 그러나 안에 들어가는 내용이 많다면 위와 같이 {} 사용해야한다.
        //동일한 이벤트리스너를 여러개 등록하면 당연하게도 마지막에 작성된 코드만 반영됨
        tvHello.setOnClickListener(view -> Log.d(TAG, "한줄짜리 클릭 테스트"));



        //문제 1 - 이벤트 리스너 생성 tvHello2

        //문제 2 - 이벤트 리스너 생성 tvHello3
        TextView tvHello2 = findViewById(R.id.tvHello2);
        TextView tvHello3 = findViewById(R.id.tvHello3);

        tvHello2.setOnClickListener(view -> {
            Log.d(TAG, "박스2 클릭함");
        });

        tvHello3.setOnClickListener(view -> {
            Log.d(TAG, "박스3 클릭함");
        });
    }
}