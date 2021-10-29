package com.example.myactivity_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    TextView one;
    TextView two;
    TextView three;
    TextView four;
    TextView five;
    TextView six;
    TextView seven;
    TextView eight;
    TextView nine;
    TextView zero;
    TextView ca;
    TextView plus;
    TextView minus;
    TextView multi;
    TextView div;
    TextView result;
    String newValue = "0";
    String oldValue = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initData();
        addEventListener();
    }

    private void initData(){
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        ca = findViewById(R.id.ca);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multi = findViewById(R.id.multi);
        div = findViewById(R.id.div);
        result = findViewById(R.id.result);
    }

    private void addEventListener(){
        //1. 이벤트 리스너 달기
        //2. result.setText(넘겨받은 값을 세팅)
        //3. 계산기 로직의 핵심을 생각해내야 한다.

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", one.getText().toString());
                newValue = newValue + "1";
                result.setText(newValue);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", two.getText().toString());
                newValue = newValue + "2";
                result.setText(newValue);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", three.getText().toString());
                newValue = newValue + "3";
                result.setText(newValue);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", four.getText().toString());
                newValue = newValue + "4";
                result.setText(newValue);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", five.getText().toString());
                newValue = newValue + "5";
                result.setText(newValue);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", six.getText().toString());
                newValue = newValue + "6";
                result.setText(newValue);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", seven.getText().toString());
                newValue = newValue + "7";
                result.setText(newValue);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", eight.getText().toString());
                newValue = newValue + "8";
                result.setText(newValue);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", nine.getText().toString());
                newValue = newValue + "9";
                result.setText(newValue);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", zero.getText().toString());
                newValue = newValue + "0";
                result.setText(newValue);
            }
        });
        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", ca.getText().toString());
                newValue ="0";
                result.setText(newValue);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", plus.getText().toString());
                /*
                oldValue ="0"
                newValue =???
                Integer.parseInt("1");
                분할앤정복방식
                1.newValue 담기
                2.oldValue 담기
                3.형변환 --> int
                4.덧셈연산자
                5.setText 메서드 사용
                */

                int preNum = Integer.parseInt(oldValue);
                int nextNum = Integer.parseInt(newValue);
                Log.d("TAG", preNum+"");
                Log.d("TAG", nextNum+"");
                int sum = (preNum+nextNum);
                oldValue = String.valueOf(sum);
                newValue = "0";
                result.setText(oldValue);


            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int preNum = 0;
                int nextNum = 0;

                preNum = Integer.parseInt(newValue);
                Log.d("TAG", "newValue" + newValue);
                nextNum = Integer.parseInt(oldValue);

                /*
                int preNum = Integer.parseInt(oldValue);
                int nextNum = Integer.parseInt(newValue);
                int sum = (preNum-nextNum);
                oldValue = String.valueOf(sum);
                newValue = "0";
                result.setText(oldValue);
                 */
                if(!oldValue.equals("0")){
                    int sum = (preNum - nextNum);
                    Log.d("TAG", preNum + " : preNum");
                    Log.d("TAG", nextNum + " : nextNum");
                    Log.d("TAG", sum + " : sum");
                    oldValue = String.valueOf(sum);
                    newValue = "0";
                    result.setText(oldValue);
                }else{
                    oldValue = newValue;
                    newValue = "0";
                }

            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int preNum = Integer.parseInt(oldValue);
                int nextNum = Integer.parseInt(newValue);
                Log.d("TAG", preNum+"");
                Log.d("TAG", nextNum+"");
                int sum = (preNum*nextNum);
                oldValue = String.valueOf(sum);
                newValue = "0";
                result.setText(oldValue);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int preNum = Integer.parseInt(oldValue);
                int nextNum = Integer.parseInt(newValue);
                Log.d("TAG", preNum+"");
                Log.d("TAG", nextNum+"");
                int sum = (preNum%nextNum);
                oldValue = String.valueOf(sum);
                newValue = "0";
                result.setText(oldValue);
            }
        });
    }
}

